package com.agan.book.config.controller;

import com.agan.book.config.base.enums.EnumHttp403Error;
import com.agan.book.config.crypt.AuthToken;
import com.agan.book.config.crypt.Constants;
import com.agan.book.config.exception.APIException;
import com.agan.book.config.resolver.SessionUser;
import com.agan.book.config.resolver.SessionUserResolver;
import com.agan.book.config.service.AuthService;
import com.agan.book.config.service.SessionService;
import com.agan.book.config.utils.CookieUtils;
import com.agan.book.config.utils.MD5Utils;
import com.agan.book.config.utils.StringUtil;
import com.agan.book.config.vo.req.Login;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿甘 http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RestController
public class TestController  {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SessionService sessionService;

	@Autowired
	private AuthService authService;

	private String msg;

	@GetMapping("/test")
	public String test(HttpServletRequest request){
		msg = "hello";
		String terminalType = request.getHeader("X-SGW-TerminalType");

		return this.msg+":"+terminalType;
	}

	@GetMapping("/orders")
	public String order(HttpServletRequest request) {

		SessionUser sessionUser= null;
		try {
			sessionUser = SessionUserResolver.getSessionUserFromGateway(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		msg = "hello"+sessionUser.getUserId();
		String terminalType = request.getHeader("X-SGW-TerminalType");

		return this.msg+":"+terminalType;
	}

	@PostMapping("/test2")
	public String test2(@RequestBody Map map) throws APIException,Exception{
//		if(null==map.get("userName")||StringUtil.isEmpty(""+map.get("userName"))){
//			throw new APIException(EnumHttp403Error.ATTR_USER_NAME_NOT_FOUND);
//		}
		msg = "hello";
		int x=  1/0;
		return this.msg;
	}
	/**
	 * 登录
	 */
	@PostMapping("/auth/login")
	@ResponseBody
	public Map<String,String> loginApi(@RequestBody Login login, HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(! login.validate()){
			throw new Exception("用户名或密码不能为空！");
		}
		//用户信息
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("userName", login.getUserName().trim());
		query.put("password", MD5Utils.getMD5(login.getPassword().trim()));
		query.put("userStatus", "NORMAL");


		//创建token
		AuthToken authToken = authService.createAuthToken(200L, Constants.UserType.CLIENT_USER,Constants.AUTH_TOKEN_AGE_MAX);
		String token = authToken.token();
		//缓存到redis
		sessionService.createSession(authToken,Constants.AUTH_TOKEN_AGE_MAX);


		CookieUtils.setCookie(request,response,Constants.AUTH_TOKEN_NAME, token,Constants.AUTH_TOKEN_AGE_MAX);

		Map<String,String> maps=new HashMap<String,String>();
		maps.put("token",token);
		maps.put("userName","admin");
		maps.put("userId",200L+"");
		maps.put("cellphone","15618367925");
		maps.put("photo","http://163.com/png");



		return maps;
	}
	@GetMapping("/auth/profile")
	@ResponseBody
	public SessionUser getSessionUser(HttpServletRequest request, HttpServletResponse response) {

		String tokenString = getTokenString(request);
		if (StringUtils.isBlank(tokenString)) {
			logger.warn("Not found authToken in cookie");
			return null;
		}
		// parse AuthToken ,解析token 信息，不正常则直接返回
		AuthToken authToken = null;
		try {
			authToken = AuthToken.parse(tokenString);
		} catch (Exception e) {
			logger.error("Failed decrypt token: {}, exception: {}", tokenString, e.getMessage());
			CookieUtils.deleteCookie(request,response, Constants.AUTH_TOKEN_NAME);
			return null;
		}
		//校验是否活跃的
		if (! AuthToken.isActive(authToken)) {
			logger.warn("authToken cookie expired: {}={}", Constants.AUTH_TOKEN_NAME, tokenString);
			CookieUtils.deleteCookie(request,response,Constants.AUTH_TOKEN_NAME);
			return null;
		}
		try{
			return sessionService.getSession(authToken);

		}  catch (Exception e){
			logger.error("session inactive, userId:, exception: {}", authToken.userId, e.getMessage());
			sessionService.deleteSession(authToken);
			return null;
		}

	}

	protected String getTokenString(HttpServletRequest httpRequest) {
		String tokenString = null;

		// from querystring
		if (StringUtils.isBlank(tokenString)) {
			tokenString = httpRequest.getParameter("user_token");
		}

		// from header
		if (StringUtils.isBlank(tokenString)) {
			tokenString = httpRequest.getHeader("user_token");
		}

		// from cookie
		if (httpRequest.getCookies() != null) {
			for (Cookie c : httpRequest.getCookies()) {
				if ("_MCH_AT".equals(c.getName())) {
					tokenString = c.getValue();
					break;
				}
			}
		}
		System.out.println(tokenString);
		return tokenString;
	}
}

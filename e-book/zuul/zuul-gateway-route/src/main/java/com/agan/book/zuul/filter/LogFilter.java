package com.agan.book.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 
*@author
*@version 1.0
 */
@Component
public class LogFilter extends ZuulFilter{

	private static final Logger logger =LoggerFactory.getLogger(LogFilter.class);
	public static final ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<Map<String, String>>();

	/**
	 * 开启过滤器
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的作用，打印请求的信息
	 */
	@Override
	public Object run() {
		RequestContext rc=RequestContext.getCurrentContext();
		HttpServletRequest request=rc.getRequest();
		Map keyrMap = request.getParameterMap();
//		Map valueMap = request.getParameterValues()
		logger.info("!!!!!!!",keyrMap.toString());

		logger.info("method={},url={}",request.getMethod(),request.getRequestURL().toString());
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}

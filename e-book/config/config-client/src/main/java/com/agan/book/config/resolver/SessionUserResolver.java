package com.agan.book.config.resolver;

import com.alibaba.fastjson.JSON;
import jodd.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/**
 * specification
 * <p>
 * 处理用户session token相关函数
 * ================================
 * Martin:
 * 解析来自网关的请求会话的用户信息，暂定为使用Header，并且给定默认值便于开发，如下（user的具体字段根据实际情况调整）
 * X-SGW-SESSION-USER: {"userId":1234, "username":"martin", "fullname":"韩亚伟", "cellphone":"18812345678", "photo":"http://xxxx", "email":"hanyawei@kuaicto.com"}
 *
 * @author Spector
 * @email : qianshanshan@kuaicto.com
 * @date: 2017/11/15
 * @time: 上午11:36
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/15 上午11:36
 */
public class SessionUserResolver {

    public static final String SESSION_USER = "X-SGW-SESSION-USER";
    public static final String SESSION_USER_ENCODED = "X-SGW-SESSION-USER-ENCODED";

    /**
     * 获取网关传输的 用户信息
     *
     * @return
     */
    public static SessionUser getSessionUserFromGateway(HttpServletRequest request)  {
        return getSessionUserFromGateway(request, SessionUser.class);
    }

    /**
     * 获取网关传输的 用户信息，返回指定的Bean类型对象
     *F
     * @return
     */
    public static <T> T getSessionUserFromGateway(HttpServletRequest request, Class<T> clazz)  {
    	// 中文乱码bugfix
        final String encoded = request.getHeader(SESSION_USER_ENCODED);
        if (StringUtil.isNotEmpty(encoded)) {
        	try {
				String decode = URLDecoder.decode(encoded, "UTF-8");
		        return JSON.parseObject(decode, clazz);
			} catch (UnsupportedEncodingException e) {
				// empty
			}
        }

        // 默认情况：兼容旧版本
    	String sessionToken = request.getHeader(SESSION_USER);
        if (StringUtil.isEmpty(sessionToken)) {
            try {
                throw new Exception("出错了！！！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSON.parseObject(sessionToken, clazz);
    }
}

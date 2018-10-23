package com.agan.book.config.utils;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public abstract class CookieUtils {
    protected static final Logger logger = LoggerFactory.getLogger(CookieUtils.class);

//    public static String getCookieDomain() {
//        // 先获取配置
//        String domain = "${cookie.domain}";//"user_token";// ConfigLoader.loadEnvConfig().get("cookie.domain");
//        // 若配置为空，则使用当前请求的环境信息
//        if (StringUtils.isBlank(domain)) {
//            domain = "user_token";
//            ThreadContext.get("cookie.domain");
//        }
//
//        return domain;
//    }

    public static void setCookie(String name, String value, String path, String domain, Integer cycle, HttpServletResponse response) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(value) || response == null) {
            return;
        }


        Cookie cookie = new Cookie(name, value);

        if (StringUtils.isBlank(path)) {
            cookie.setPath("/");
        } else {
            cookie.setPath(path);
        }

//        if (StringUtils.isBlank(domain)) {
////            String systemDomain = CookieUtils.getCookieDomain();
////            if (StringUtils.isNotBlank(systemDomain)) {
////                cookie.setDomain(systemDomain);
////            }
//        } else {
//            cookie.setDomain(domain);
//        }

        if (cycle != null) {
            cookie.setMaxAge(cycle);
        }

        response.addCookie(cookie);
    }

    /**
     * 得到Cookie的值, 不编码
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        return getCookieValue(request, cookieName, false);
    }

    /**
     * 得到Cookie的值,
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder) {
    	// synchronized for debug
    	synchronized(request) {
	    	logger.debug("Request Cookies: {}", request.getHeader("Cookie"));
	    	
	        Cookie[] cookieList = request.getCookies();
	        if (cookieList == null || cookieName == null) {
	            return null;
	        }
	        String retValue = null;
	        try {
	            for (int i = 0; i < cookieList.length; i++) {
	            	// for more logging
	            	if (cookieList[i] == null) {
//	            		logger.warn("Found null cookie at:{}, Request Cookies:{}, cookieList:{}", i, request.getHeader("Cookie"), JsonUtil.toJsonQuietly(cookieList));
	            		continue;
	            	}
	            	
	                if (cookieList[i].getName().equals(cookieName)) {
	                    if (isDecoder) {
	                        retValue = URLDecoder.decode(cookieList[i].getValue(), "UTF-8");
	                    } else {
	                        retValue = cookieList[i].getValue();
	                    }
	                    break;
	                }
	            }
	        } catch (UnsupportedEncodingException e) {
	            logger.error("Cookie Decode Error.", e);
	        }
	        return retValue;
    	}

    }

    /**
     * 得到Cookie的值,
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    retValue = URLDecoder.decode(cookieList[i].getValue(), encodeString);
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("Cookie Decode Error.", e);
        }
        return retValue;
    }

    /**
     * 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue) {
        setCookie(request, response, cookieName, cookieValue, -1);
    }

    /**
     * 设置Cookie的值 在指定时间内生效,但不编码
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue, int cookieMaxage) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, false);
    }

    /**
     * 设置Cookie的值 不设置生效时间,但编码
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue, boolean isEncode) {
        setCookie(request, response, cookieName, cookieValue, -1, isEncode);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue, int cookieMaxage, boolean isEncode) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数(指定编码)
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue, int cookieMaxage, String encodeString) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString);
    }

    /**
     * 删除Cookie带cookie域名
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response,
                                    String cookieName) {
        doSetCookie(request, response, cookieName, "", -1, false);
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
                                          String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0) {
                cookie.setMaxAge(cookieMaxage);
            }

            if (null != request) {// 设置域名的cookie
//                cookie.setDomain(getDomainName(request));
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            logger.error("Cookie Encode Error.", e);
        }
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
                                          String cookieName, String cookieValue, int cookieMaxage, String encodeString) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else {
                cookieValue = URLEncoder.encode(cookieValue, encodeString);
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0) {
                cookie.setMaxAge(cookieMaxage);
            }
            if (null != request) {// 设置域名的cookie
                cookie.setDomain(getDomainName(request));
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            logger.error("Cookie Encode Error.", e);
        }
    }

    /**
     * 得到cookie的域名
     */
    private static final String getDomainName(HttpServletRequest request) {
        String domainName = null;

        String serverName = request.getRequestURL().toString();
        if (serverName == null || serverName.equals("")) {
            domainName = "";
        } else {
            serverName = serverName.toLowerCase();
            serverName = serverName.substring(7);
            final int end = serverName.indexOf("/");
            serverName = serverName.substring(0, end);
            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            if (len > 3) {
                // www.xxx.com.cn
                domainName = "." + domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
            } else if (len <= 3 && len > 1) {
                // xxx.com or xxx.cn
                domainName = "." + domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }

        if (domainName != null && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }
}

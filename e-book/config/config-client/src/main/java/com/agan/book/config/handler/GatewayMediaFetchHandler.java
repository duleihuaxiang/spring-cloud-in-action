//package com.agan.book.config.handler;
//
//import com.kuaicto.framework.core.Handler;
//import com.kuaicto.framework.kit.ThreadLocalKit;
//import com.kuaicto.spec.resolver.RequestMediaResolver;
//import com.kuaicto.spec.resolver.SessionUserResolver;
//import org.apache.commons.lang3.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 网关媒介获取 Handler
// */
//public class GatewayMediaFetchHandler extends Handler {
//
//    @Override
//    public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        final String xSgwRequestId = httpServletRequest.getHeader(RequestMediaResolver.SGW_REQUEST_ID);
//        final String xSgwSessionUser = httpServletRequest.getHeader(SessionUserResolver.SESSION_USER);
//        final String xSgwSessionUserEncoded = httpServletRequest.getHeader(SessionUserResolver.SESSION_USER_ENCODED);
//        logger.debug("request header param, {}:{}, {}:{}, {}:{}",
//                RequestMediaResolver.SGW_REQUEST_ID, xSgwRequestId,
//                SessionUserResolver.SESSION_USER, xSgwSessionUser,
//                SessionUserResolver.SESSION_USER_ENCODED, xSgwSessionUserEncoded);
//
//        Map<String, String> headerMap = new HashMap<>(2);
//        if (StringUtils.isNotBlank(xSgwRequestId)) {
//            headerMap.put(RequestMediaResolver.SGW_REQUEST_ID, xSgwRequestId);
//        }
//        if (StringUtils.isNotBlank(xSgwSessionUser)) {
//            headerMap.put(SessionUserResolver.SESSION_USER, xSgwSessionUser);
//        }
//        if (StringUtils.isNotBlank(xSgwSessionUserEncoded)) {
//            headerMap.put(SessionUserResolver.SESSION_USER_ENCODED, xSgwSessionUserEncoded);
//        }
//
//        ThreadLocalKit.GLOBAL_THREAD_LOCAL.set(headerMap);
//
//        super.next.handle(s, httpServletRequest, httpServletResponse);
//
//        ThreadLocalKit.GLOBAL_THREAD_LOCAL.remove();
//    }
//}

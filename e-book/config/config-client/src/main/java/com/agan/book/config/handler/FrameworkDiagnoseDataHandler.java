//package com.agan.book.config.handler;
//
//import com.kuaicto.framework.core.Handler;
//import com.kuaicto.framework.kit.LoggerKit;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * smart-spring-boot-web
// * 框架级诊断信息
// * <p>
// * Description :
// * 记录一些框架级别信息到Response Handle
// * 目前包括 :
// * rid - 请求ID
// * <p>
// * <p>
// * Creator :
// *
// * @author Sudao @ Tim Zhang
// * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
// * @date: 2017/11/12
// * @time: 上午10:40
// * =========================================
// * <p>
// * Contributors :
// * Tim Zhang - 2017/11/12 上午10:40
// */
//public class FrameworkDiagnoseDataHandler extends Handler {
//    /******* Fields Area *******/
//
//    /******* Construction Area *******/
//    public FrameworkDiagnoseDataHandler() {
//    }
//
//    @Override
//    public void handle(String url, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        try {
//            this.next.handle(url, request, response);
//        } finally {
//            response.addHeader("rid", LoggerKit.getRID());
//        }
//    }
//    /******* GetSet Area ******/
//
//    /******* Method Area *******/
//
//
//}

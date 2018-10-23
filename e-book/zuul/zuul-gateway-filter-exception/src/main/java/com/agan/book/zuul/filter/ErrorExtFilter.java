//package com.agan.book.zuul.filter;
//
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//@Component
//public class ErrorExtFilter extends SendErrorFilter {
//
//    @Override
//    public String filterType() {
//        return "error";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 30; // 大于ErrorFilter的值
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        // 判断：仅处理来自post过滤器引起的异常
//        RequestContext ctx = RequestContext.getCurrentContext();
//        ZuulFilter failedFilter = (ZuulFilter) ctx.get("failed.filter");
//        if (failedFilter != null && failedFilter.filterType().equals("error")) {
//            return true;
//        }
//        return false;
//    }
//}

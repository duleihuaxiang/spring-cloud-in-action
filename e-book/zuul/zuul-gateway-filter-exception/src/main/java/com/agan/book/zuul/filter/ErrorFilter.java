package com.agan.book.zuul.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * 
*异常处理
 */
@Component
public class ErrorFilter extends ZuulFilter{

	private static final Logger logger =LoggerFactory.getLogger(ErrorFilter.class);
	
	/**
	 * 开启过滤器
	 */
	@Override
	public boolean shouldFilter() {

		RequestContext ctx = RequestContext.getCurrentContext();
//		Throwable throwable = ctx.getThrowable();
		return ctx.contains("error.status_code");
	}

	/**
	 * 过滤器的作用，post验证
	 */
	@Override
	public Object run() {
		RequestContext context=RequestContext.getCurrentContext();

		logger.info("--------------error-------------------");
		Throwable throwable = context.getThrowable();
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
//		logger.error("this is a ErrorFilter :{}",throwable.getCause().getMessage());
//		context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//		context.set("error.message",throwable.getCause().getMessage());

		String hh = request.getMethod()+request.getAttribute("javax.servlet.error.message");

		hh+="--"+request.getAttribute("javax.servlet.error.request_uri");
		hh+="--"+request.getAttribute("javax.servlet.error.exception_type");
		hh+="--"+request.getAttribute("javax.servlet.error.exception");
		hh+="--"+request.getAttribute("javax.servlet.error.servlet_name");


		RequestContext ctx = RequestContext.getCurrentContext();
//		Throwable throwable = ctx.getThrowable();
		hh+=ctx.get("error.status_code");
		hh+=ctx.get("error.exception");
		hh+=ctx.get("error.message");

		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1000;
	}

}

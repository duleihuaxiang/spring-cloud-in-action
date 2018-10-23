package com.agan.book.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice

public class ErrorGatewayController {



//	@RequestMapping("/error")
//	public String handleError(HttpServletRequest request, HttpServletResponse response){
//		//获取statusCode:401,404,500
//		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//		if(statusCode == 401){
//			return "/401";
//		}else if(statusCode == 404){
//			return "/404";
//		}else if(statusCode == 403){
//			return "/403";
//		}else{
//			String hh = request.getMethod()+request.getAttribute("javax.servlet.error.message");
//
//			hh+="--"+request.getAttribute("javax.servlet.error.request_uri");
//			hh+="--"+request.getAttribute("javax.servlet.error.exception_type");
//			hh+="--"+request.getAttribute("javax.servlet.error.exception");
//			hh+="--"+request.getAttribute("javax.servlet.error.servlet_name");
//
//
//			RequestContext ctx = RequestContext.getCurrentContext();
//			Throwable throwable = ctx.getThrowable();
//			hh+=ctx.get("error.status_code");
//			hh+=ctx.get("error.exception");
//			hh+=ctx.get("error.message");
//
//			return hh;
//		}
//
//	}
//	@Override
//	public String getErrorPath() {
//		return "/error";
//	}

	@ExceptionHandler(value=BusinessException.class)
	public Map<String,Object> errorHandler(BusinessException ex){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code", ex.getCode());
		map.put("msg", ex.getMsg());
		return map;

	}

}

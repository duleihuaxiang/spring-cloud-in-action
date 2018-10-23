package com.agan.book.product.facade;

import java.util.List;

import com.netflix.zuul.context.RequestContext;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agan.book.product.domain.Product;
import com.agan.book.product.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 阿甘
 * @see http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RestController
@EnableAsync //开启异步调用
public class ProductFacadeImpl implements ProductFacade{
	
	@Autowired
	private ProductService productService;

	@RequestMapping("list")
	public List<Product> findAllProduct(){
		return  this.productService.findAllProduct();
	}
	public List<Product> listProduct(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  this.productService.findAllProduct();
	}

	@Override
	public Product getProduct(Integer id) throws Exception {

		try {

			int i = 9 / 0;
			return this.productService.getProduct(id);

		}catch (Exception ex){
//			Throwable a = ex;
			RequestContext ctx = RequestContext.getCurrentContext();
//
			ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			ctx.set("error.exception",ex);
			ctx.set("error.message", ex.getMessage());
//			ctx.setSendZuulResponse(false);//代表结束请求，不在继续下级传递。
			return null;


		}

//
//


	}

	@Override
	public Product getProduct1(@RequestBody Product obj) {
		return obj;
	}

	@Override
	public Product getProduct2(Integer id, String name) {
		return new Product(id,name);
	}

	@Override
	public Product addProduct(@RequestBody Product obj) {
		return obj;
	}




	
	
}

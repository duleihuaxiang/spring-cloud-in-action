package com.agan.eureka.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agan.eureka.provider.domain.Product;
/**
 * @author 阿甘 http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RestController
public class ProductController {
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product> listProduct(){
		List<Product> list=new ArrayList<Product>();
		list.add(new Product(1,"漫谈spring cloud与spring boot基础架构（微服务基础篇）"));
		list.add(new Product(2,"漫谈spring cloud分布式服务架构（微服务进阶篇）"));
		list.add(new Product(3,"漫谈spring cloud 与docker架构部署（微服务高级篇）"));
		return  list;
	}
}

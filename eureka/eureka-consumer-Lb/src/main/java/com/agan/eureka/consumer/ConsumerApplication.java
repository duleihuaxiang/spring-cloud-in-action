package com.agan.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
/**
 * @author 阿甘 http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ConsumerApplication {

//	@Bean
//	public IRule ribbonRule(){
//		return new RandomRule();
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}

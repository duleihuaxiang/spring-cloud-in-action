package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author dudu
 * @see
 * @version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.goods.mapper")
public class FrameworkApplication {
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(FrameworkApplication.class, args);
	}
}

package com.bubu0218.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ServletInitializer.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServletInitializer.class, args);
	}
}

//@SpringBootApplication
//public class RestapiApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(RestapiApplication.class, args);
//	}
//
//}
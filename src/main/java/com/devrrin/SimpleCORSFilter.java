package com.devrrin;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SimpleCORSFilter implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
				.allowedMethods("GET", "PATCH", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*");
		WebMvcConfigurer.super.addCorsMappings(registry);
	}
}
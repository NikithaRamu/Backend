package com.nikitha.fsd.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.nikitha.fsd.zuul.filter.JWTFilter;
import com.nikitha.fsd.zuul.filter.PreFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean jwtFilter(){
		final FilterRegistrationBean filterBean=new FilterRegistrationBean();
		filterBean.setFilter(new JWTFilter());
		filterBean.addUrlPatterns("/recommend/api/v1/recommend/*","/gipher/api/v1/bookmark/*");
		return filterBean;
	}
	

}

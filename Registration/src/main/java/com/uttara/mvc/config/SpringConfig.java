package com.uttara.mvc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.uttara.mvc.*")
public class SpringConfig implements WebMvcConfigurer{
	
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		System.out.println("in SpringConfig");
		
		registry.jsp("WEB-INF/jsps/", ".jsp");
	}

//	public void addViewControllers(ViewControllerRegistry registry) {
//		// TODO Auto-generated method stub
//		ViewControllerRegistration r = registry.addViewController("/");
//		r.setViewName("Home");
//	}
}

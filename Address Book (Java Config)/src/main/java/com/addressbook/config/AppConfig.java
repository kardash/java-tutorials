package com.addressbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import javax.annotation.PostConstruct;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.addressbook")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	 @Autowired
	 private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
	
	 @PostConstruct
	 public void initApp() {
		 requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
	 }
	 
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}

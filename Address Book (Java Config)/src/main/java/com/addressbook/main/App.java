package com.addressbook.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.addressbook.config.AppConfig;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = 
			      new AnnotationConfigApplicationContext(AppConfig.class);
	}

}

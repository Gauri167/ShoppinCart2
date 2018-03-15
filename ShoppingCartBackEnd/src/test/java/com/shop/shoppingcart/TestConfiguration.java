package com.shop.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfiguration {

	public static void main(String[] args) {
		
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.shop");
	context.refresh();
	context.getBean("user");
	System.out.println("Successfully created Instance");
}
}

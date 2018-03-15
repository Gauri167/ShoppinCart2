package com.shop.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTestCaseTest {

	private static AnnotationConfigApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass()  {
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
	}
    @Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

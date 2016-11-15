package com.mindtree.mwatch.test;

import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	
	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		
		applicationContext = new ClassPathXmlApplicationContext(
				"/ApplicationContext.xml");

		for (String bean : applicationContext.getBeanDefinitionNames())
			System.out.println("bean :::::" + bean);
		CamelContext context = (CamelContext) applicationContext
				.getBean("defaultCamelContext");

		try {
			context.start();

			Thread.sleep(100000l);

			context.stop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}

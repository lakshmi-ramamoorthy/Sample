package com.mindtree.mwatch.test;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

public class TestRouteBuilder  extends RouteBuilder{
	
	public TestRouteBuilder() {
		
		System.out.println(">>Object created");
	}

	@Override
	public void configure() throws Exception {
		
			System.out.println( ">> Builder called");
			from("restlet:/hello")
		 .transform().constant("Hello World");
      
	}

}

package com.mindtree.mwatch.test;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class TestRouteBuilder  extends RouteBuilder{
	

	public TestRouteBuilder() {
		
		System.out.println(">>Object created");
	}

	@Override
	public void configure() throws Exception {
		
		System.out.println( ">> Builder called");
		from("restlet:/hello").transform().constant("Hello World");
		
		from("restlet:/user/{userId}?restletMethods=GET").bean(Service.class, "getUserDetails");
      
	}
	
	public void customerDetail()
	{
		System.out.println("Customer Detail");
	}

}

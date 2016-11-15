package com.mindtree.mwatch.test;

public class Service implements ServiceInt {
	
	public String getUserDetails() {
		
		System.out.println("User Details called");
		return "User Details called";
	}

}

package com.java.methodandreference;

import java.util.function.Supplier;

/*
 * Constructor reference example with no arguments 
 * 
*/
public class ConstructorRefExample1 {

	public static void main(String[] args) {
		
		CustomerConstructorInterface1 ref = CustomerConstructorExample1::new;
		ref.getCustomer();
		//or
		Supplier<CustomerConstructorExample1> supRef = ()->new CustomerConstructorExample1();
		supRef.get();
		//or
		Supplier<CustomerConstructorExample1> supRef2 = CustomerConstructorExample1::new;
		supRef2.get();
		
		
	}
	
}

interface CustomerConstructorInterface1{
	CustomerConstructorExample1 getCustomer();
}

class CustomerConstructorExample1{
	
	public CustomerConstructorExample1() {
		System.out.println("no argument constructor called");
	}
}
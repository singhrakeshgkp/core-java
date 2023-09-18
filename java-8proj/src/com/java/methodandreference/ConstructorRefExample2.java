package com.java.methodandreference;

import java.util.function.Function;

/*
 * Constructor reference example with single arguments 
 * 
*/
public class ConstructorRefExample2 {

	public static void main(String[] args) {
		
		CustomerConstructorInterface2 ref = CustomerConstructorExample2::new;
		ref.getCustomer("hello world");
		//or
		Function<String,CustomerConstructorExample2> funRef = (t)-> new CustomerConstructorExample2("with lambda");
		funRef.apply("Hellowfdsfdsffd");
		//or
		Function<String, CustomerConstructorExample2> funRef1 = CustomerConstructorExample2::new;
		funRef1.apply("calling constructor approach 3");
		
		
	}
	
}

interface CustomerConstructorInterface2{
	CustomerConstructorExample2 getCustomer(String str);
}

class CustomerConstructorExample2{
	
	public CustomerConstructorExample2() {
		
	}
	public CustomerConstructorExample2(String str) {
		System.out.println("single argument constructor called - "+str);
	}
}
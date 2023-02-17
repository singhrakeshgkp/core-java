package com.java.methodandreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/*
 * Constructor reference example with two arguments 
 * 
*/
public class ConstructorRefExample3 {

	public static void main(String[] args) {
		
		CustomerConstructorInterface4 interfaceRef = CustomerConstructorExample4::new;
		interfaceRef.getAddresses("USA","43 street fremount", "union city");
		//OR
		BiFunction<String, String[], CustomerConstructorExample4> biRef = (t1,t2)->new CustomerConstructorExample4(t1, t2);
		biRef.apply("USA", "denver1,denver1".split(","));
		//OR
		BiFunction<String,String[],CustomerConstructorExample4> biRef2 = CustomerConstructorExample4::new;
		biRef2.apply("IND", "noida,delhi".split(","));
		
	}
	
}

interface CustomerConstructorInterface4{
	CustomerConstructorExample4 getAddresses(String country,String ... strings );
}

class CustomerConstructorExample4{
	
	List<String>addresses;
	String country;
	
	public CustomerConstructorExample4() {
		
	}
	public CustomerConstructorExample4(String country, String ... addresses) {
		
		this.addresses = Arrays.asList(addresses);
		this.country = country;
		System.out.println(country+", "+this.addresses);
		
	}
}
package com.java.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest3 {
	
/* 
 * Sometimes syntax of static and non static will be same, it depends on the context you are dealing with
 * */
	
	public static void main(String[] args) {

		
		 List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		 numbers.stream()
		 		.map(e->String.valueOf(e))
		 		.map(e->e.toString())
		 		.map(String::toString)//
		 		.forEach(System.out::println);
	}
	
	
	
	
	
}

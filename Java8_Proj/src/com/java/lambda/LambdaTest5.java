package com.java.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest5 {
	
/* Method References
 * 1. function composition
 * */
	
	public static void main(String[] args) {

		
		 List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		 System.out.println(
		 numbers.stream()
	 		.filter(e->e%2 ==0)
	 		.mapToInt(e->e*2)
	 		.sum());
		 		
		
	}
}

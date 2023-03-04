package com.java.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest6 {
	
/* Method References
 * 1. Two Parameters one as target the other one as argument
 * */
	
	public static void main(String[] args) {

		
		 List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		 System.out.println(
		 numbers.stream()
		 		.map(String::valueOf)
		 		//.reduce("",(carry,str)->carry.concat(str))); equivalent to .reduce("",String::concat));
		 		  .reduce("",String::concat));
		 		
		
	}
}

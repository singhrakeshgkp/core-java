package com.java.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest4 {
	
/* Method References
 * 1. Two Parameters as an argument
 * */
	
	public static void main(String[] args) {

		
		 List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		 System.out.println(
		 numbers.stream()
		 		//.reduce(0,(total,e)->Integer.sum(total,e)));//remove the common(total,e) from both side and replace dot with double colon
		 		  .reduce(0,Integer::sum));
		
	}
}

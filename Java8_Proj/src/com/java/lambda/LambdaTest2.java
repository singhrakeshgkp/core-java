package com.java.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest2 {
	
/*External Internal Iterators
 *
 * 
 * */
	
	public static void main(String[] args) {
		
	 List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	 System.out.println("External iterators start");
	 for(int i=0; i<numbers.size(); i++) {
		 System.out.println(""+numbers.get(i));
	 }
	 
	 System.out.println("External iterators end");
	 numbers.stream().map(String::valueOf)// static reference
	 .forEach(System.out::println);
	}	
}

package com.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

public class LambdaTest8 {
	
/* 
 * Collectors
 * 1. wrong way
 *    -> mutability is okay, sharing is nice, shared mutability is devils work
 *    -> Friends don't let friends do shared mutation
 * 2. right way
 * */
	
    	/*1. wrong way*/
        public static void wrongWay() {
            List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	    List<Integer> doubleOfEvenNums = new ArrayList<>();
		 System.out.println("result from wrongWay");
		  numbers.stream()
		        .filter(e->e%2==0)
		        .map(e->e*2)
		        .forEach(e->doubleOfEvenNums.add(e));
		  System.out.println(doubleOfEvenNums);
        }
        
	/*2. Right way*/
        
        public static void rightWay() {
            List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
            List<Integer> doubleOfEvenNums = new ArrayList<>();
		 System.out.println("result from rightWay ");
	 doubleOfEvenNums= numbers.stream()
		        .filter(e->e%2==0)
		        .map(e->e*2)
		        .collect(toList());
	 
	 System.out.println(doubleOfEvenNums);
		 		
		 		
        }
	public static void main(String[] args) { 		
	   
	    wrongWay();
	    rightWay();
	}
}

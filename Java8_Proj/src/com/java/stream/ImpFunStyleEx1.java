package com.java.stream;

import java.util.Arrays;
import java.util.List;

public class ImpFunStyleEx1 {

	/*Task 1 - Given numbers, double all the even numbers and compute their sum
	
	 * */
	public static void main(String[] args) {
	
		functionalStyle();
		imperativeStyle();
	}
	public static void imperativeStyle() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		int total =0;
		for(int num : numbers) {
			if(num %2==0) {
				total+= num*2;
			}
		}
		System.out.println("Total from imperative style programming "+total);
	}
	
	public static void functionalStyle() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(
				numbers.stream().filter(e->e%2==0)
				.mapToInt(e->e*2)
				.sum()
				);
		
	}
}

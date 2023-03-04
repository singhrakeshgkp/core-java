package com.java.stream;

import java.util.Arrays;
import java.util.List;

public class StreamVsParallelStreamEx1 {

	/*
	 * Task2- Parallelize the functional style code.
	 * Approach 1- if u are the owner(u created the stream) of the stream
	 * 
	 * */
	public static void main(String[] args) {
	 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		numbers.parallelStream()
			   .map(ele->process(ele))
			   .forEach(number->System.out.println(number));
	}
	
	public static int process(int element) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return element;
	}
}

package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsParallelStreamEx2 {

	/*
	 * Task3- Parallelize the functional style code
	 * Approach :- Using stream.parallel() method - use this technique if u are not source of stream
	 * 
	 * */
	public static void main(String[] args) {
	 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		printElements(numbers.stream());
			   
	}
	
	public static void printElements(Stream<Integer> stream) {
		stream.parallel()// parallelize the stream if u are not source/creator of stream
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

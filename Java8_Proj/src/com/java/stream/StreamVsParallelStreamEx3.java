package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsParallelStreamEx3 {

	/*
	 * 
	 * */
	public static void main(String[] args) {
	 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		numbers.stream()
			   .parallel()// its not parallel the very last one gonna win that is sequential
			   .map(ele->process(ele))
			   .sequential()
	      .forEach(number->System.out.println(number));
			   
	}
	
	
	public static int process(int element) {
		try {
			System.out.println("processing element "+element);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return element;
	}
}

package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class StreamVsParallelStreamEx8 {

	/*Continue from point 11 discussed in code{StreamVsParallelStreamEx7} class
	 * 12. How many number of thread by default will be created in parallel stream ?
	 *	 * */
	public static void main(String[] args) {
	 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(ForkJoinPool.commonPool());
			   
	}
	
	

}

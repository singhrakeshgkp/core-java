package com.java.stream;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamVsParallelStreamEx9 {

	/*
	 * Continue from point 12 discussed in code{StreamVsParallelStreamEx8} class 
	 * 13. Run this application with and without parallel.
	 *     Output-> with Parallel approx 3 to 5 second
	 *              without Parallel approx 12 to 16 second
	 * *
	 */
	public static void main(String[] args) {

		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		 
		long startTime = Instant.now().getEpochSecond();
		double result =  IntStream.range(0, 2000)
					  .parallel()
					  .mapToDouble(Test::computeSquireRoot)
					  .sum();
						
      long endTime = Instant.now().getEpochSecond();
      System.out.println("time taken "+(endTime-startTime));
		System.out.println("result "+result);
	}

	
}

class Test{
	private static  int MAX = 2000;
	
	public static double computeSquireRoot(double number) {
		double result = 0;
		for(int i =0; i<MAX; i++) {
			for (int j =0; j< MAX; j++) {
				result += Math.sqrt(i*j);
			}
		}
		return result;
	}
}

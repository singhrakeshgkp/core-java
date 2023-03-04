package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class StreamVsParallelStreamEx10 {

	/*
	 * Continue from point 13 discussed in code{StreamVsParallelStreamEx9} class 
	 * 14. create a stream in main method and send it to process method
	 *     run the application and perform stream.forEach(ele->{}); operation in preform method
	 *     output-> you will observe stream is running in common pool
	 * 15. Now in transform mehtod create new  ForkJoinPool and submit the taks to it
	 *     output-> Stream will run in ForkJoinPool-1 not Common pool, that means it runs on based on
	 *     where terminal operation is running not based on where stream is created.
	 *     
	 * *
	 */
	public static void main(String[] args) throws InterruptedException {

		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,50,51,52,53,54,55,56,57,58,59,60
				,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79);
		 
	
		process(numbers.parallelStream().map(ele->transform(ele)));
	}

	

	private static void process(Stream<Integer> stream) throws InterruptedException {
		ForkJoinPool pool = new ForkJoinPool(1000);
		pool.submit(()->stream.forEach(ele->{}));
		pool.shutdown();
		pool.awaitTermination(5, TimeUnit.SECONDS);
		///stream.forEach(ele->{});
	}
	private static int transform(Integer ele) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("element "+ele+" "+Thread.currentThread().getName());
		return ele;
	}
	
}


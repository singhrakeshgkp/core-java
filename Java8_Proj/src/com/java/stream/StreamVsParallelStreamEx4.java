package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsParallelStreamEx4 {

	/*1. Run the application you will observe one element will be printed by main thread only, 
	 *   while other by ForkJoinPool.commonPool-worker*
	 *2. Now comment syso available in process and print in forEach(number->System.out.println(number))
	 *   run it as sequential stream, result will be printed in order as we are using List
	 *   which is ordered collection
	 *3. Now run it using parallel stream. Output will be unordered(no Guaranteed )
	 *Note:- Some methods are inherently ordered
	 *     - some methods are unordered but may have an ordered counterpart
	 *5. Now use foreachOrdered instead of foreach. output will be ordered 
	 *Note:- foreachOrdered does not convert pipeline into sequential, this is concurrent execution
	 *       except that it says that i will not run until once before me is completed. So it impose
	 *       ordering but not sequential execution.
	 *       so foreachOrdered doesn't guaranteed ordering unless the stream guaranteed the ordering.      
	 * */
	public static void main(String[] args) {
	 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		numbers.parallelStream()
			   .map(ele->process(ele))
	      .forEachOrdered(number->System.out.println(number));
			   
	}
	
	
	public static int process(int element) {
		try {
	//		System.out.println("processing element "+element+" "+Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return element;
	}
}

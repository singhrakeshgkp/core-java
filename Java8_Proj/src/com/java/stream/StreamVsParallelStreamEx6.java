package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsParallelStreamEx6 {

	/*Continue from point 6 discussed in code{StreamVsParallelStreamEx5} class
	 *7. Run it will Stream-> Output will be ordered 
	 *8. Run it will parallel Stream and forEachOrdered -> output will be ordered
	 *	 * */
	public static void main(String[] args) {
	 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		numbers.parallelStream()
			   .filter(ele->oddEven(ele))
	      .forEachOrdered(number->printEle(number));
			   
	}
	
	
	public static boolean oddEven(int element) {
		try {
	  System.out.println("processing element "+element+" "+Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
	
public static void printEle(int element) {
	System.out.println("print "+ element+ " "+Thread.currentThread().getName());
}
}

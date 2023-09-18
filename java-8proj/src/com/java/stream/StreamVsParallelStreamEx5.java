package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsParallelStreamEx5 {

	/*Continue from point 5 discussed in code{StreamVsParallelStreamEx4} class
	 *6. Print the number and thread in process method. also define new method named "print"
	 *   in this method print the- number with "print" string prefix
	 *   output - you will observe processing is happening in unorder fashion while printing in order fashion
	 * */
	public static void main(String[] args) {
	 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		numbers.parallelStream()
			   .map(ele->process(ele))
	      .forEachOrdered(number->printEle(number));
			   
	}
	
	
	public static int process(int element) {
		try {
	  System.out.println("processing element "+element+" "+Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return element;
	}
	
public static void printEle(int element) {
	System.out.println("print "+ element+ " "+Thread.currentThread().getName());
}
}

package com.java.stream;

import java.util.Arrays;
import java.util.List;

public class StreamVsParallelStreamEx7 {

	/*Continue from point 8 discussed in code{StreamVsParallelStreamEx6} class
	 *9.  Run it will Stream-> Output will be 36 
	 *10. Run it will parallel Stream -> Output will be 36
	 *11. But if u pass initial value like 10 instead of 0 ".reduce(10,(total,e)->add(total,e)));"
	 *    this time with initial value 10 it will not produce desired result
	 *    reduce -> does not take an initial value, it takes an identity value
	 *    int + identity is 0 x+0 = x
	 *    int * identify is 1 x*1 = x
	 *    important point is what we work with should be a monoid(need to explore more)
	 *    
	 *	 * */
	public static void main(String[] args) {
	 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		System.out.println(
				numbers.parallelStream()
				   .reduce(10,(total,e)->add(total,e)));
		
	}
	
	
	public static int add(int x,int y) {
		
			int result = x+y;
			System.out.println("x="+x+" y= "+y+" result= "+result+"--"+Thread.currentThread().getName());
		
		return result;
	}
	
public static void printEle(int element) {
	System.out.println("print "+ element+ " "+Thread.currentThread().getName());
}
}

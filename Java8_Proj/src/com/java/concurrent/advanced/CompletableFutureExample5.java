package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample5 {

	/*Step 1 print the result using future.get() method -> Output sequential execution blocking call
	 *step 2 print the result suing future.getNow(0)-> output Non blocking call
	 *       Future is not resolved- return default value passed in getNow(0) which is zero
	 *       Future is resolve- return the value from future(to test this add sleep in main and remove sleep from compute)
	 *
	 * */
	public static CompletableFuture<Integer> getCompFuture(){
		return CompletableFuture.supplyAsync(()->compute(5));
	}
	
	public static int compute(int num) {
		
		//	Thread.sleep(2000);
		
		return num;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		CompletableFuture<Integer> future = getCompFuture();
		//System.out.println(future.get());
		Thread.sleep(1000);
		System.out.println(future.getNow(0));
		System.out.println("finishing main");
	}
	

}



package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample11 {

	/*Creating a long pipeline, transforming the data using thenApply method
	 * 1. Complete the future using complete method-> output it should print result 11
	 * 2. Complete the future using completeExceptionally->Output it should recover
	 *    from error channel and print the result 5
	 * */
	
	
	
	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static int handleException(Throwable throwable) {
		System.out.println("in exception block "+throwable);
		return 0;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<Integer> future = new CompletableFuture<Integer>();
		future.thenApply(data->data*2)
		.exceptionally(throwable->handleException(throwable))
		.thenApply(data->data+5)
		.thenAccept(data->System.out.println("data is "+data));
		System.out.println("Pipeline is built");
		sleep(1000);
		//future.complete(3);
		future.completeExceptionally(new RuntimeException("something went wrong"));
		
	}
	

}



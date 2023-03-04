package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample13 {

	/*If we do not resolve the future by calling complete method its status will be
	 * pending for long time. To deal with it java 9 introduces timeout methods,
	 * Note:- completeOnTimeout will be invoked only if future state is pending and timeout occurs
	 *        if future state is rejected or resolved(can be done using complete method)
	 *        in that case completeOnTimeout will never be called
	 * 
	 * 
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
		future.orTimeout(2, TimeUnit.SECONDS);
		sleep(1000);
		//future.complete(3);
		sleep(2000);
		
		
		
	}
	

}



package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample9 {

	/*Creating a long pipeline, transforming the data using thenApply method
	 * and completing the future explicitly 
	 * */
	
	
	
	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void print(int value) {
		
		System.out.println(value+"  "+Thread.currentThread());
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<Integer> future = new CompletableFuture<Integer>();
		future.thenApply(data->data*2)
		.thenApply(data->data+5)
		.thenAccept(data->System.out.println("data is "+data));
		System.out.println("Pipeline is built");
		sleep(1000);
		future.complete(3);
		
	}
	

}



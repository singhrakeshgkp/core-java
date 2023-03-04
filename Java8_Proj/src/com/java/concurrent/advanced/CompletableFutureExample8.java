package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample8 {

	/*
	 * */
	
	public static CompletableFuture<Integer> getCompFuture(){
		return CompletableFuture.supplyAsync(()->compute(5));
	}
	
	public static int compute(int num) {
		
		//sleep(1000);	
		System.out.println(num+"-----"+Thread.currentThread());
		return num;
	}
	
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
		
		System.out.println("In main "+Thread.currentThread());
		getCompFuture().thenApply(data->data*20)
					   .thenAccept(data->System.out.println(data))
					   .thenRun(()->System.out.println("task executed successfully"));
		
	}
	

}



package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class CompletableFutureExample7 {

	/*Instead of common pool the thread will run in ForkJoinPool-1-worker pool
	 * */
	
	public static CompletableFuture<Integer> getCompFuture(){
		ForkJoinPool pool = new ForkJoinPool(10);
		return CompletableFuture.supplyAsync(()->compute(5),pool);
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
		CompletableFuture<Integer>future =getCompFuture();
		sleep(100);
		future.thenAccept((data)->print(data));
		System.out.println("Main End");
		//sleep(2000);
	}
	

}



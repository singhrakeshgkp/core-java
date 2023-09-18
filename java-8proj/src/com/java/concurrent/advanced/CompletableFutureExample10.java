package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample10 {

	/*
	 * 1. In case of exception it goes to nearest exceptionally method
	 * 2. in case of success it goes to nearest then method
	 * 3. Following diagram shows how recovery form exception and flow is coming
	 *    back to data channel form error channel
	 *    
	 * -----f----f------f              f------f-----f       data Channel
	 * 					\             /
	 *                  f-------f----f                      error Channel
	 *
	 * */
	
	
	public static CompletableFuture<Integer> getCompFuture(){
		return CompletableFuture.supplyAsync(()->compute(5));
	}
	
	public static int compute(int num) {
		
		throw new RuntimeException();
	//	return num;
	}
	
	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Void handleException(Throwable throwable) {
		System.out.println("exception occurred "+throwable);
		throw new RuntimeException("handleException something went wrong");
	}
	
	public static int handleException2(Throwable throwable) {
		System.out.println(" handleException2 exception occurred "+throwable);
		return -2;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		getCompFuture().thenApply(data->data*3)
		               .exceptionally(throwable->handleException2(throwable))//will recover from here
		               .thenAccept(data->System.out.println(data))
		               .exceptionally(throwable->handleException(throwable));
		
	}

}



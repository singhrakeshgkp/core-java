package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample14 {

	/*
	 * 
	 * */
	
	
	public static CompletableFuture<Integer> getCompleFuture(int num){
		return CompletableFuture.supplyAsync(()->num);
	}
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
		
		getCompleFuture(2).thenCombine(getCompleFuture(3), (result1,result2)->result1+result2)
		                  .thenAccept(data->System.out.println(data));
		
	}
	

}



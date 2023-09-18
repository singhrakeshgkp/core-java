package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample15 {

	/*1. we use thenCompose if the function is returning CompletableFuture not data.
	 *2. if we execute this program it will print completableFuture kind value not data
	 *3. To get rid of that we have to use thenCompose
	 *
	 *Note:- when we call getCompleFuture second time, the method returns following type
	 *        CompletableFuture<CompletableFuture<Integer>> thats why used here thenCompose
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
		
		getCompleFuture(2).thenApply(data->getCompleFuture(data))
						  .thenCompose(data->data)
						  .thenAccept(data->System.out.println(data));
		
	}
	

}



package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample6 {

	/*Step 1 By the time you get out of the sleep, completable future has already completed now
	 *       future.thenAccept() cfuture says i am done, i am not gonna wait for you as a result
	 *       cf will let main do the work or by the time you call future.thenAccept(), main says
	 *       hey look data is available i am not gonna switch the thread i might as well exe it in main thread.
	 *
	 *step 2  Introduce sleep in compute with 1 sec and in main with 2 sec
	 *        -> output you will observe that the print and compute will be exe in different thread not in main
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
		CompletableFuture<Integer>future =getCompFuture();
		sleep(100);
		future.thenAccept((data)->print(data));
		System.out.println("Main End");
		//sleep(2000);
	}
	

}



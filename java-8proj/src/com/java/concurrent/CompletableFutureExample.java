package com.java.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
	
/* 1. runAsync :- if you want to run something aynchronously and do not want to return any think
 * 2. 
 * 
 *  
 *  
 *  */
	
public static void runAsynchExample() throws InterruptedException, ExecutionException {
	CompletableFuture<Void> compFuture = CompletableFuture.runAsync(()->{
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hi this is running is a separate thread");
	});
	
	compFuture.whenComplete((k,v)->{
		
		System.out.println("in when complete block");
	});
	System.out.println("in main thread after calling runAsynchExample() method");
	compFuture.get();
	
}
 public static void main(String[] args) throws InterruptedException, ExecutionException {
		
 //1.
	 runAsynchExample();
	 System.out.println("in main thread after calling runAsynchExample() method");
 }
 
}

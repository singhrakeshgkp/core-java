package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample3 {

	private String greet;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> future = CompletableFuture.supplyAsync(CompletableFutureExample3::process);
		future.thenAccept(f->System.out.println(f));
										 
		
	}
	
	public static String process() {
	CompletableFutureExample3 obj = new CompletableFutureExample3();
	 obj.greet = "hello world";
	 return obj.greet;
	}
}



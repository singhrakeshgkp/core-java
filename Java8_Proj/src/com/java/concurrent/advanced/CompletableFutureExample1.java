package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample1 {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		/*
		 *complete()-> Lets you manually complete the future with the given value
		 */
		CompletableFuture<String> comFuture = new CompletableFuture<>();
		boolean results = comFuture.complete("hello world");
		System.out.println(results);
		System.out.println(comFuture.get());
	}
}

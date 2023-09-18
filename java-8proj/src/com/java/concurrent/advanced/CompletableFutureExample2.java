package com.java.concurrent.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureExample2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ThenApplyExample2.thenApplyEx2();//will add two number and return their sum with addition String
		ThenApplyExample1.thenApplyEx1();// will print Shri Krishna
		ThenApplyExample3.thenApplyEx3();// will print some
	}
}


class ThenApplyExample1{
	
	public static void thenApplyEx1() throws InterruptedException, ExecutionException {

		CompletableFuture<String> comFuture = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Krishna";
		}).thenApply(data->"Shri "+data);
		String msg = comFuture.get();
		System.out.println(msg);
	
	}
}

class ThenApplyExample2{
	
	public static void thenApplyEx2() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> compFuture1 = CompletableFuture.supplyAsync(()->sum(20,50));
		CompletableFuture<String> compFuture2 = compFuture1.thenApply(result->printSum(result));
		String result = compFuture2.get();
		System.out.println(result);
		
	}
	
	public static int sum(int num1, int num2) {
		return num1+num2;
	}
	
	public static String printSum(int result) {
		return "sum is "+result;
	}
}


class ThenApplyExample3{
	
	public static void thenApplyEx3() {
		List<Integer> numList = Arrays.asList(5,10,15,20);
		numList.stream()
		.map(num->CompletableFuture.supplyAsync(()->num*num))
		.map(comfutureObj->comfutureObj
		.thenApply(result->"fdsfd "+result))
		.map(thread->thread.join())
		.forEach(System.out::println);
		
		
	}
	
}

package com.java.concurrent.advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

public class CompletableFutureExample4 {

	/*Step 1- We created completable future of type CompletableFuture<Integer>
	 *Step 2. we call future.thenAccept(consumer) it will return completable future of void
	 *Step 3. on void completable future we can call method which takes nothing and return nothing 
	 *        example run method of Runnable interface.
	 * 
	 * 
	 * */
	public static CompletableFuture<Integer> getCompFuture(){
		return CompletableFuture.supplyAsync(()->2);
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		/*Popular functional interface
		 * Supplier<T>  T get()			- factories
		 * Predicate<T> boolean Test(T)		- filter
		 * Functional<T,R> R apply(T)		- map
		 * Consumer<T> void accept(T)		- foreach
		 * BiConsumer<T,U,R>  void accept(T t, U u);
		 * 
		 * */
		getCompFuture().thenAccept(data->System.out.println(data))//step 1
		.thenRun(()->System.out.println("This never dies"))// step 2
		.thenRun(()->System.out.println("This really never dies")) //step 2
		.thenRun(()->System.out.println("This really really never dies")); //step 4
	}
	

}



package com.java.concurrent.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolWithRTExample {

	public static void main(String[] args) {

		List<Item> items = ItemFactory.getItems(11);
		RecursiveTaskDemoTask task = new RecursiveTaskDemoTask(0, items.size(), items);
		ForkJoinPool fjp = new ForkJoinPool();
		double result =fjp.invoke(task);
		
		fjp.shutdown();
		System.out.println("result is :- "+result);
		System.out.println();
	}
}


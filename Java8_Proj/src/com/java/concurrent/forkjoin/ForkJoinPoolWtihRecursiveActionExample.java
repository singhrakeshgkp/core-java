package com.java.concurrent.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/*
 * 1. RecursiveAction -> it doesn't return any value
*/
public class ForkJoinPoolWtihRecursiveActionExample {
	
 public static void main(String[] args) {
	List<Item> items = ItemFactory.getItems(2000);
	RecursiveActionDemoTask task = new RecursiveActionDemoTask(items, 0, items.size(), 0.3);
	ForkJoinPool fjp = new ForkJoinPool();
	fjp.execute(task);
	do {
		System.out.println("");
		System.out.printf("Main active thread: %d\n", fjp.getActiveThreadCount());
		System.out.printf("Main queued task count: %d\n", fjp.getQueuedTaskCount());
		System.out.printf("Main steal count: %d\n", fjp.getStealCount());
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}while(!task.isDone());
	fjp.shutdown();
	if(task.isCompletedNormally()) {
		System.out.println("task completed normally");
	}
	
	for(int i =0; i<items.size(); i++) {
		System.out.println("item: "+items.get(i).getItemId()+" price "+items.get(i).getItemPrice());
	}
}
}

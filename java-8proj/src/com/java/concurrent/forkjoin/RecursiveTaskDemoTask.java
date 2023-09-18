package com.java.concurrent.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemoTask  extends RecursiveTask<Double>{

	private int startIndx;
	private int endIndx;
	List<Item> items;
	private static final int THRESHOLD = 2;
	
	
	public RecursiveTaskDemoTask(int startIndx, int endIndx, List<Item> items) {
		super();
		this.startIndx = startIndx;
		this.endIndx = endIndx;
		this.items = items;
	}

	@Override
	protected Double compute() {
		if(endIndx-startIndx<=2) {
			return process();
		}
			int middle = (startIndx+endIndx)/2;
			System.out.println("task : pending : %s\n"+getQueuedTaskCount());
			RecursiveTaskDemoTask task1 = new RecursiveTaskDemoTask(startIndx, middle, items);
			RecursiveTaskDemoTask task2 = new RecursiveTaskDemoTask(middle,endIndx , items);
			task1.fork();
		    double task2Result = task2.compute();
		    double task1Result = task1.join();
		    return task1Result+task2Result;
		
	}


	private double process() {
		double result =0.0;
		for(int i =startIndx; i<endIndx; i++) {
			
			result += items.get(i).getItemPrice();
		}
		return result;
	}
	

}

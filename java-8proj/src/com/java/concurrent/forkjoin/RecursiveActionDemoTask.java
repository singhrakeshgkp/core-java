package com.java.concurrent.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionDemoTask extends RecursiveAction{

	private List<Item> items;
	private int startIndx;
	private int lastIndx;
	private double incr;
	
	
	public RecursiveActionDemoTask(List<Item> items, int startIndx, int lastIndx, double incr) {
		
		this.items = items;
		this.startIndx = startIndx;
		this.lastIndx = lastIndx;
		this.incr = incr;
	}


	@Override
	protected void compute() {
		if(lastIndx - startIndx< 20) {
			updatePrices();
		}else {
			int middle = (startIndx+lastIndx)/2;
			System.out.println("task : pending : %s\n"+getQueuedTaskCount());
			RecursiveActionDemoTask task1 = new RecursiveActionDemoTask(items, startIndx, middle, incr);
			RecursiveActionDemoTask task2 = new RecursiveActionDemoTask(items, middle+1, lastIndx, incr);
			invokeAll(task1, task2);

		}
		
	}


	private void updatePrices() {
		for(int i=startIndx; i<lastIndx; i++) {
			items.get(i).setItemPrice(items.get(i).getItemPrice()*(1+incr));
		}
		
	}

}

package com.java.concurrent;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable{

	private final List<Integer> queue;
	private final int  maxCap;
	public Producer(List<Integer> queue, int maxCap) {
		this.queue = queue;
		this.maxCap = maxCap;
	}
	
	@Override
	public void run() {
		
		int counter = 0;
		while(true) {
			try {
				produce(counter++);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		synchronized (queue) {
			while(queue.size() == maxCap) {
				System.out.println("queue is full "+ Thread.currentThread().getName()+" is waiting");
			    queue.wait();
			}
			Thread.sleep(1000);
			queue.add(i);
			
			System.out.println("produced  "+i);
			queue.notifyAll();
			
		}
		
	}
	
}


class Consumer implements Runnable {
	private final List<Integer> queue;

	public Consumer(List<Integer> queue) {
     this.queue = queue;
    
	}

	
	@Override
	public void run() {

		while(true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private void consume() throws InterruptedException {
		
		synchronized (queue) {
			while(queue.isEmpty()) {
				System.out.println("queue is empty");
				queue.wait();
			}
		Thread.sleep(1000);
	    Integer consumedInt = 	queue.remove(0);
		System.out.println("message is consumed "+consumedInt);
		queue.notifyAll();
		}
	}

}


public class ThreadWithWaitAndNotifyPubLisherConsumerExample {

	public static void main(String[] args) {
		
		/* 1 Producer and consumer example */
		List<Integer> queue = new ArrayList<>();
		int maxCap = 5;
		Thread producerThread = new Thread(new Producer(queue, maxCap),"producer");
		Thread consumerThread = new Thread(new Consumer(queue),"consumer");
		producerThread.start();
		consumerThread.start();
	
		
	 
	
	}
}

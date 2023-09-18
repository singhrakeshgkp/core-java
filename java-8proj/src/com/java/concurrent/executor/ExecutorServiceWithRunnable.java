package com.java.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceWithRunnable {

	public static void main(String[] args) {
		/*We can create following types of executors
		 * Note- There are other ways to create the executor service as well, like using constructor etc.
		 * */
		/*
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		ExecutorService singleThreadPoolExecutor = Executors.newSingleThreadExecutor();
		ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
		*/
		ExecutorService es = Executors.newFixedThreadPool(4);
		for(int i=0;i<10;i++) {
			Runnable workerThread = new WorkerThread();
			es.execute(workerThread);
		}
		es.shutdown();
		// Wait for thread to be terminated
		while(!es.isTerminated());
		
		System.out.println("all thread finished its task");
	}
}

class WorkerThread implements Runnable{

	@Override
	public void run() {
		System.out.println("starting "+Thread.currentThread().getName());
		try {
			TimeUnit.MICROSECONDS.sleep(1000);
			
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Ending "+Thread.currentThread().getName());
		
	}
}

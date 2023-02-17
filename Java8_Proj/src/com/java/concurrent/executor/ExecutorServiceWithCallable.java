package com.java.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceWithCallable {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		List<Future<String>> list = new ArrayList<>();
		for(int i=0;i<100;i++) {
			Callable<String> callable = new WorkerThreadCallable();
		 Future<String> future = es.submit(callable);
		 list.add(future);
		}
	  for(Future<String> fut : list) {
		  try {
		/*
		 * Print the returned value of future. Notice the output delay in console.
		 * because future.get() method waits for the task to be completed.
		 */  
			System.out.println(fut.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	  }
	  
	  es.shutdown();
	  //wait for the thread to be terminated
	  while(!es.isTerminated());
	}
}

class WorkerThreadCallable implements Callable<String>{

	
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return Thread.currentThread().getName();
		
	}
	
}

package com.java.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadWithSleepExample {

	public static void main(String[] args) {

		
		System.out.println("main thread start");
		Runnable runnableObj = ()->{
			int i = 1;
			while(i<=10) {
				
				System.out.println("counting "+Thread.currentThread().getName()+" counter "+i);
				i++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Interrupted Exception occurred");
					e.printStackTrace();
				}
			}
		};
		
	Thread t1 = new Thread(runnableObj);
	Thread t2 = new Thread(runnableObj);
	t1.start();
	t2.start();
	
	System.out.println("Main thread finished its task");
	
	}
}

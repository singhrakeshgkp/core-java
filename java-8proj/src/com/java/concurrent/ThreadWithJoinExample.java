package com.java.concurrent;


public class ThreadWithJoinExample {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("main thread start");
		Runnable runnableObj = ()->{
			int i = 1;
			System.out.println("counting 1 to 10 "+Thread.currentThread().getName());
			while(i<=1) {
				System.out.println(" "+i);
				i++;
			}
		};
		
	Thread t1 = new Thread(runnableObj);
	Thread t2 = new Thread(runnableObj);
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	System.out.println("Main thread finished its task");
	}
}

package com.java.concurrent;


public  class JavaThreadExample {

	public static void main(String[] args) throws InterruptedException  {
		System.out.println("before calling join from current thread");
		System.out.println(Thread.currentThread().getState());
		RunnableDemo runnable = new RunnableDemo();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t1.start();
		
		
		t1.join();
		System.out.println("after calling join from current thread");
		System.out.println(Thread.currentThread().getState());
		t2.start();
		
				
		
	}
}

class RunnableDemo implements Runnable{
	@Override
	public void run() {
	
		System.out.println(Thread.currentThread().getName()+" counting from 1 to 10");
		for(int i =0; i<10; i++) {
	
		System.out.println(i);
		}
	}
}

package com.java.lambda;

public class LambdaTest1 {
	
/*Possible way to declare lambda expression
 * 1. (parameters)->expression;
 * 2. (parameters)-> {statements;}
 * 3. ()-> expression;
 * */
	
	public static void main(String[] args) {
	    
	    
	}
	
	
	public static void createThreadUsingLambda() {
		Thread th = new Thread(()->System.out.println("Running in separate thread "+Thread.currentThread()));
		th = new Thread(()->System.out.println("Running in separate thread "+Thread.currentThread()));
		th = new Thread(()->System.out.println("Running in separate thread "+Thread.currentThread()));
		th = new Thread(()->System.out.println("Running in separate thread "+Thread.currentThread()));
		th = new Thread(()->System.out.println("Running in separate thread "+Thread.currentThread()));
		th = new Thread(()->System.out.println("Running in separate thread "+Thread.currentThread()));
		th = new Thread(()->System.out.println("Running in separate thread "+Thread.currentThread()));
		th = new Thread(()->System.out.println("Running in separate thread "+Thread.currentThread()));

	}
/*	public static void createThreadWithAnonymousClass() {

		
		
		Thread th = new Thread(new Runnable() {
			public void run() {	
				System.out.println("Thread running"+Thread.currentThread());
			}
		});
		th = new Thread(new Runnable() {
			public void run() {	
				System.out.println("Thread running"+Thread.currentThread());
			}
		});
		th = new Thread(new Runnable() {
			public void run() {	
				System.out.println("Thread running"+Thread.currentThread());
			}
		});
		th = new Thread(new Runnable() {
			public void run() {	
				System.out.println("Thread running"+Thread.currentThread());
			}
		});
		th = new Thread(new Runnable() {
			public void run() {	
				System.out.println("Thread running"+Thread.currentThread());
			}
		});
	
	}
	
	
	*/
	
	
}

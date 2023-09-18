package com.java.concurrent;

class OddEvenCounter {

	public int counter=0;
	public static int MAX_VAL = 10;
	
	public void printEvenNumber() throws InterruptedException {
		synchronized (this) {
			while(counter<=MAX_VAL) {
				while(counter%2 !=0) {
					wait();
				}
				System.out.println(Thread.currentThread().getName()+" "+counter);
				counter++;
				this.notify();
			}
		}
	}
	public void printOddNumber() throws InterruptedException {
		synchronized (this) {
			while(counter<=MAX_VAL) {
				while(counter%2==0) {
					this.wait();
				}
				System.out.println(Thread.currentThread().getName()+" "+counter);
				counter++;
				notifyAll();
			}
		}
	}

}

public class ThreadWithWaitAndNotifyOddEvenApproach1 {

	public static void main(String[] args) {
		OddEvenCounter oddEvenObj = new OddEvenCounter();
		Runnable runnable1 = ()->{
			try {
				oddEvenObj.printEvenNumber();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable runnable2 = ()->{
			try {
				oddEvenObj.printOddNumber();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
	Thread t1 = new Thread(runnable1,"T1");
	Thread t2 = new Thread(runnable2,"T2");
	t1.start();
	t2.start();
	}
}

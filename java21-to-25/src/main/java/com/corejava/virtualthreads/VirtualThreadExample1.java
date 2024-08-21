package com.corejava.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExample1 {


  public static void main(String[] args) throws InterruptedException {

    /*Creating virtual thread
    approach 1*/
    Thread.ofVirtual().start(()-> System.out.println(Thread.currentThread()));
    //approach 2
    Thread.startVirtualThread(()-> System.out.println(Thread.currentThread()));
    //approach 3

    /* If observe the output of the below program u will see multiple virtual thread is getting mounted
    on same worker/platfor/carrier thread*/
    try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
    }
    //Creating platform thread
    Thread.ofPlatform().start(()-> System.out.println(Thread.currentThread()));
  }
}

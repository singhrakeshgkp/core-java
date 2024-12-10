package com.core.mt;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("main start");
    CountDownLatch latch = new CountDownLatch(3);
    WorkerThread workerThread = new WorkerThread(latch);
    for (int i = 0; i < 3; i++) {
      Thread t = new Thread(workerThread);
      t.setName("Child Thread "+i);
      t.start();
    }
    latch.await();
    System.out.println("main end");
  }
}

class WorkerThread implements  Runnable{
  private CountDownLatch countDownLatch;
  public WorkerThread(CountDownLatch countDownLatch){
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run(){
    try{
      System.out.println("current thread "+Thread.currentThread().getName());
    }catch (Exception ex){
     ex.printStackTrace();
    }finally{
      countDownLatch.countDown();
    }
  }
}
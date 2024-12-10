package com.core.mt;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {
  public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
    CyclicBarrier barrier = new CyclicBarrier(3);
    CyclicBarrierWorkerThread runnable = new CyclicBarrierWorkerThread(barrier);
    for (int i = 0; i < 3; i++) {
      Thread t = new Thread(runnable);
      t.start();
    }
  }
}

 class CyclicBarrierWorkerThread implements  Runnable{
  private CyclicBarrier barrier;
  public CyclicBarrierWorkerThread(CyclicBarrier barrier){
    this.barrier = barrier;
  }
  @Override
  public void run() {
    try{
      System.out.println("Thread "+Thread.currentThread().getName()+"reached to point B");
      //Thread.sleep(500);
    }catch (Exception ex){
      ex.printStackTrace();
    }

    try{
      //lets say this is common point
      barrier.await();
    }catch (Exception ex){
      ex.printStackTrace();
    }
    System.out.println("Thread "+Thread.currentThread().getName()+" continue its journeey after Point B");
  }
}
package com.core.mt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserEx {

  public void executeTask(){
    Phaser phaser = new Phaser(1);// passed 1 to register main thread
    Runnable acitivityOfXAndY= ()->{
      activity1(phaser);
      activity2(phaser,false);
      activity3(phaser);
    };

    Runnable acitivityOfZ= ()->{
      activity2(phaser, true);
      activity3(phaser);
    };

    Runnable finalActivities =
        () -> {
          activity2(phaser, false);
          activity3(phaser);
        };
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    executorService.execute(new WorkerThreadPhaser(acitivityOfXAndY, phaser,"x and y"));
    executorService.execute(new WorkerThreadPhaser(acitivityOfZ, phaser,"z"));

    phaser.arriveAndAwaitAdvance();
    executorService.execute(new WorkerThreadPhaser(finalActivities, phaser,"a"));
    executorService.execute(new WorkerThreadPhaser(finalActivities, phaser,"b"));
    phaser.arriveAndDeregister();
  }
  public static void main(String[] args){
 PhaserEx obj = new PhaserEx();
 obj.executeTask();
  }

  private  void activity3(Phaser phaser) {
    System.out.println("activity 3 thread "+Thread.currentThread().getName());
    phaser.arriveAndDeregister();
  }

  private static void activity2(Phaser phaser, boolean isLeaving) {
    System.out.println("activity 2 thread "+Thread.currentThread().getName());
    if(isLeaving){
      phaser.arriveAndDeregister();
    }else{
      phaser.arriveAndAwaitAdvance();
    }
  }

  private static void activity1(Phaser phaser) {
    System.out.println("activity 1 thread "+Thread.currentThread().getName());
    phaser.arriveAndAwaitAdvance();
  }
}

class  WorkerThreadPhaser implements Runnable{
  private Runnable task;
  private Phaser phaser;
  private String threadName;

  public WorkerThreadPhaser(Runnable task, Phaser phaser, String threadName) {
    this.task = task;
    this.phaser = phaser;
    this.threadName = threadName;
    this.phaser.register();
  }

  @Override
  public void run() {
    Thread.currentThread().setName(threadName);
    task.run();
  }

  public String getThreadName() {
    return threadName;
  }

  public void setThreadName(String threadName) {
    this.threadName = threadName;
  }
}
package com.corejava.virtualthreads;

public class CustomVirtualThreadClient {

  private static final VirtualThreadScheduler SCHEDULER = new VirtualThreadScheduler();
  public static void main(String[] args) {
    new Thread(SCHEDULER::start).start();
    var vt1 = new CustomVirtualThread(()->{
      System.out.println("1-A");
      System.out.println("1-B");
      System.out.println("1-C");
    });

    var vt2 = new CustomVirtualThread(()->{
      System.out.println("2-A");
      System.out.println("2-B");
      System.out.println("2-C");
    });
    SCHEDULER.schedule(vt1);
    SCHEDULER.schedule(vt2);
  }
}

package com.corejava.virtualthreads;

import java.util.concurrent.atomic.AtomicInteger;
import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class CustomVirtualThread {

  private  final static AtomicInteger COUNTER = new AtomicInteger(1);
  private Continuation continuation;
  public static final ContinuationScope SCOPE = new ContinuationScope("custom VT");
  private int id;
  public CustomVirtualThread(Runnable runnable) {
    continuation = new Continuation(SCOPE, runnable);
    id = COUNTER.getAndIncrement();
  }

  public void run() {
    System.out.println("custom virtual thread "+id+" running on " + Thread.currentThread());
    continuation.run();
  }

}

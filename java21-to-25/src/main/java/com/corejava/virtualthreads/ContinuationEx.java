package com.corejava.virtualthreads;

import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class ContinuationEx {

  public static void main(String[] args) {
    var cont = getContinuationInstance();
    cont.run();
    // will start from previous state
    cont.run();
    // will start from previous state
    cont.run();
    // will start from previous state
    cont.run();
    // will throw error as continuation has terminated/finished its execution
    //cont.run();
  }

  public static Continuation getContinuationInstance() {
    var contScope = new ContinuationScope("Test");
    var cont = new Continuation(contScope,()->{
      System.out.println("One");
      Continuation.yield(contScope);
      System.out.println("Two");
      Continuation.yield(contScope);
      System.out.println("Three");
      Continuation.yield(contScope);
      System.out.println("Four");
    });
    return cont;
  }
}

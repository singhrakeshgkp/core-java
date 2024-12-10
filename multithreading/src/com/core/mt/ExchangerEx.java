package com.core.mt;

import java.util.concurrent.Exchanger;

public class ExchangerEx {
  public static void main(String[] args){
    Exchanger<String> exchanger = new Exchanger<>();
    ExchangerWorker runnable1 = new ExchangerWorker("A",exchanger);
    ExchangerWorker runnable2 = new ExchangerWorker("B",exchanger);
    new Thread(runnable1).start();
    new Thread(runnable2).start();
  }
}

class ExchangerWorker implements  Runnable{
private Exchanger<String> exchanger;
private String obj;

  public ExchangerWorker(String obj, Exchanger<String> exchanger) {
    this.obj = obj;
    this.exchanger = exchanger;
  }

  @Override
  public void run() {
    String prevObj = this.obj;
    try {
      System.out.println("inside run "+Thread.currentThread().getName());
      this.obj = this.exchanger.exchange(this.obj);
      System.out.println(
          Thread.currentThread().getName() +
              " exchanged " + prevObj + " for " + this.obj);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}


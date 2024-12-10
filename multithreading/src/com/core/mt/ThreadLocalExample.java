package com.core.mt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
  private  static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<>(){
    @Override
    protected SimpleDateFormat initialValue(){
      return new SimpleDateFormat("yyyyMMdd HHmm");
    }
  };

  public String formatIt(Date date) throws InterruptedException {
    System.out.println("formatter obj is "+formatter.get());
    Thread.sleep(1000);
    return formatter.get().format(date);
  }
  public static void main(String[] args){

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    for(int i=0; i<10;i++){

      executorService.submit(() -> {
        try {
          ThreadLocalExample obj = new ThreadLocalExample();
          System.out.println(obj.formatIt(new Date()));
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      });
    }

  }
}

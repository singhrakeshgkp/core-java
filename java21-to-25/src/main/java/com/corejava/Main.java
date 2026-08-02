package com.corejava;

import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
      executor.submit(()-> System.out.println(Thread.currentThread()));
    }

    Thread.ofPlatform().start(()-> System.out.println(Thread.currentThread()));
    Thread.ofPlatform().start(()-> System.out.println(Thread.currentThread()));
  }
}

class Employee {

}

class Student {

}
package com.core.mt;

import com.sun.tools.javac.Main;

public class ThreadGroupEx {
  public static void main(String[] args){
    ThreadGroup group1 = new ThreadGroup("Group1");
    ThreadGroup group2 = new ThreadGroup("Group2");
    Thread t1 = new Thread(group1,() -> System.out.println("t1"));
    Thread t2 = new Thread(group1,() -> System.out.println("t2"));

    Thread t3= new Thread(group2,() -> System.out.println("t3"));
   t1.start();
   t2.start();

   t3.start();
    System.out.println(group1.activeCount());

    group1.setMaxPriority(10);

  }
}

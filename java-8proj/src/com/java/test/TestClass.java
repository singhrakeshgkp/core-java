package com.java.test;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

  // create a generic function to copy collections

  public static  <T extends  Comparable<T>> void copy(List<T> source, List<T> target , T exclude){
    for (var item: source){
      if (item.compareTo(exclude) !=0)
      target.add(item);
    }
    System.out.println(target);
  }
  public static void main(String[] args) {

    List<Integer> from = new ArrayList<>();
    from.add(10);
    from.add(30);

    List<Integer> to = new ArrayList<>();
    to.add(70);
    to.add(900);

    copy(from,to,30);
  }
}
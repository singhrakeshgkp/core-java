package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

/*1. create a function to copy the collections*/

  public static  <T extends Comparable<T>> List<T> copyExcept(List<T> from, List<T> to,T exclude){
    for (var e : from){
      if (e.compareTo(exclude) != 0)
      to.add(e);
    }
    return to;
  }
  public static void main(String[] args) {
    List<Integer> from = new ArrayList<>(Arrays.asList(8,5,4,3,2));
    List<Integer> to = new ArrayList<>(Arrays.asList(11,22,33,55,44));
    List<Integer> numbers = copyExcept(from,to,4);
    numbers.forEach(System.out::println);
  }
}
package com.java20.feature;

public class Test {

  public static void main(String[] args) {

    System.out.println(processItem(20));
  }

  private static String processItem(Object obj) {
    return switch (obj){
      case null-> "got null value";
      case Integer i  when i==20-> "got integer "+i;
      case Integer i ->"got integer something else";
      case String str-> "got string";
      default -> "default value";
    };
  }
}


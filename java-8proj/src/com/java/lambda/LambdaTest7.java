package com.java.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest7 {

  /*
   * 1. Reduce and specialized Reduce
   * */

  /*Reduce*/
  public static void reduceExample() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println("result from reduce" +
        numbers.stream()
            .map(String::valueOf)
            //.reduce("",(carry,str)->carry.concat(str)));
            .reduce("", String::concat));
  }

  /*Specialized reduce*/

  public static void specializedReduceExample() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println("result from specialized reduce " +
        numbers.stream()
            .mapToDouble(Double::valueOf)
            .sum());


  }

  public static void main(String[] args) {
    specializedReduceExample();
    reduceExample();
  }
}

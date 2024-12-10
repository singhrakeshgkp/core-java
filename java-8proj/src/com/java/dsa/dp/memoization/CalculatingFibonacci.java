package com.java.dsa.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class CalculatingFibonacci {

  /* Not efficient as it takes O(2^n)time, space complexity = O(n)*/
  public static long fib(int n){
    if(n <=2)//as fib for 1 and 2 is 1 base case
      return 1;
    return (fib(n-1)+fib(n-2));
  }

  /* optimized above function and used memoization time and space complexity = o(n)*/

  public static long fib(int n, Map<Integer,Long> memo){
    if (n<=2)
      return 1;
    if(memo.containsKey(n))
      return memo.get(n);
    long value =  fib((n-1),memo)+fib((n-2),memo);
    memo.put(n,value);
    return value;
  }
  public static void main(String[] args) {
    /*n     1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10
    fib(n)  1 , 1 , 2 , 3 , 5 , 8 , 13, 21, 34 ,55 */
    //System.out.println(fib(50)); // take more time to execute

    System.out.println(fib(50,new HashMap<>())); //much faster than above one

  }
}

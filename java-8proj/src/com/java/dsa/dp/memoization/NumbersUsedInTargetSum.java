package com.java.dsa.dp.memoization;

import java.util.Arrays;
import java.util.Map;

public class NumbersUsedInTargetSum {

  public static int[] getSumUsingNums(int sum, int[] numbers){
    if(sum == 0) return new int[0];
    if(sum < 0) return  null;
    for (int num : numbers){
      int remainingNum = sum - num;
     int [] results = getSumUsingNums(remainingNum,numbers);
     if(results != null) {
       int[] combinedResults = Arrays.copyOf(results, results.length + 1);
       combinedResults[combinedResults.length - 1] = num;
       return combinedResults;
     }
    }
    return null;
  }

  public static Integer[] memoizedGetSumUsingNums(int sum, int[] numbers, Map<Integer,Integer[]> memo){
    if(memo.containsKey(sum)) return memo.get(sum);
    if(sum == 0) return new Integer[0];
    if(sum < 0) return  null;
    for (int num : numbers){
      int remainingNum = sum - num;
      Integer [] results = memoizedGetSumUsingNums(remainingNum,numbers,memo);
      if(results != null) {
        Integer[] combinedResults = Arrays.copyOf(results, results.length + 1);
        combinedResults[combinedResults.length - 1] = num;
        memo.put(sum,combinedResults);
        return combinedResults;
      }
    }
    return null;
  }
  public static void main(String[] args) {
    /*
    * first Input 8,[2,3,5]
    * second input7,[2,4]
    * third input 7,[5,3,4,7]
    * */
    int[] numbers = {2,4};
    int sum = 8;
    int[]results = getSumUsingNums(sum,numbers);
    //Integer[] results =  memoizedGetSumUsingNums(sum,numbers, new HashMap<>());
    System.out.println(Arrays.toString(results));
  }
}

package com.java.dsa.dp.memoization;

import java.util.Map;

public class TargetedSum {
  public static boolean canSum(int sum, int[] numbers){
    if(sum == 0) return true;
    if(sum < 0) return false;
    for (int num : numbers){
      int remainingNum = sum - num;
      if(canSum(remainingNum,numbers) == true){
        return true;
      }
    }
    return false;
  }
  public static boolean memoizedCanSum(int sum, int[] numbers, Map<Integer,Boolean> memo){
    if(memo.containsKey(sum)) return memo.get(sum);
    if(sum == 0) return true;
    if(sum < 0) return false;
    for (int num : numbers){
      int remainingNum = sum - num;
      if(canSum(remainingNum,numbers) == true){
        memo.put(sum,true);
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
   int[] numbers = {5,3,4,7};
   int sum = 7;
    System.out.println(canSum(sum,numbers));
  }
}

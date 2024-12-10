package com.java.dsa.dp.memoization;

import java.util.Arrays;

public class BestSumUsingNumbers {

  public static int[] bestSum(int sum, int[] numbers){
    if(sum == 0) return new int[0];
    if(sum <0)
      return null;

    int[] bestCombination = null;
    for (int num : numbers){
      int remainder = sum-num;
      int[] result = bestSum(remainder,numbers);
      if(result != null){
        int[]combinedResult = Arrays.copyOf(result,result.length+1);
        combinedResult[result.length] = num;
        if(bestCombination == null || combinedResult.length < bestCombination.length){
          bestCombination = combinedResult;
        }
      }
    }
    return bestCombination;
  }
  public static void main(String[] args) {
    /*inputs 7,[7,4,3]----->[7]
             100,[1,2,5,25]-->[25,25,25,25]---> non memoized will take more time
    *
    * */
    int num = 7;
    int [] numbers = {4,7,3};
    int[] result = bestSum(num,numbers);
    System.out.println(Arrays.toString(result));
  }
}

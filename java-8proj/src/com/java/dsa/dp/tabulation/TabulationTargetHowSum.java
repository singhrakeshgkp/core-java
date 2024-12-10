package com.java.dsa.dp.tabulation;

import com.java.utils.ArrayUtils;
import java.util.Arrays;

public class TabulationTargetHowSum {
  static Integer[] howSum(int sum, int[] numbers){
    Integer [][] tmpArray = new Integer[sum+1][];
    tmpArray[0] = new Integer[0];

    for (int i=0; i< tmpArray.length; i++){
      if (tmpArray[i] !=null){
        for (int num : numbers){
          if ((i+num) < tmpArray.length)
          tmpArray[i+num] = ArrayUtils.insertLast(tmpArray[i],num);
        }
      }
    }
    return tmpArray[sum];
  }
  public static void main(String[] args) {
    System.out.println(Arrays.toString(howSum(7, new int[]{5,3,4}))); //[4,3]
    System.out.println(Arrays.toString(howSum(7,new int[]{3,2})));// [3,2,2]
    System.out.println(Arrays.toString(howSum(8,new int[]{2,3,5})));//[2,2,2,2]
    System.out.println(Arrays.toString(howSum(7,new int[]{2,4})));//null
  }
}

package com.java.dsa.dp.tabulation;

import com.java.utils.ArrayUtils;
import java.util.Arrays;

public class TabulationBestSum {
  static Integer[] howSum(int sum, int[] numbers){
    Integer [][] tmpArray = new Integer[sum+1][];
    tmpArray[0] = new Integer[0];

    for (int i=0; i< tmpArray.length; i++){
      if (tmpArray[i] !=null){
        for (int num : numbers){
          if ((i+num) < tmpArray.length) {
            Integer[] result = ArrayUtils.insertLast(tmpArray[i], num);
            if (tmpArray[i+num] == null || tmpArray[i+num].length ==0 || tmpArray[i+num].length>result.length)
            tmpArray[i + num] =result;
          }
        }
      }
    }
    return tmpArray[sum];
  }
  public static void main(String[] args) {
    System.out.println(Arrays.toString(howSum(7, new int[]{5,3,4,7}))); //[7]
    System.out.println(Arrays.toString(howSum(7,new int[]{3,2,4})));// [3,4]
    System.out.println(Arrays.toString(howSum(8,new int[]{1,8})));//[8]
    System.out.println(Arrays.toString(howSum(100,new int[]{25,50,20})));//[50,50]
  }
}

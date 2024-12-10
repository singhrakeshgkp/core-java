package com.java.dsa.dp.tabulation;

public class TabulationTargetSum {

  static boolean canSum(int sum, int[] numArray){
    boolean[] tmpArray = new boolean[sum+1];
    tmpArray[0] = true;
    for (int i=0; i<tmpArray.length; i++){
      if (tmpArray[i] == true){
        for (int j=0; j<numArray.length; j++){
          if((i+numArray[j]) < tmpArray.length)
          tmpArray[i+numArray[j]] = true;
        }
      }
    }
    return tmpArray[sum];
  }
  public static void main(String[] args) {
    System.out.println(canSum(7,new int[]{5,3,4}));
  }
}

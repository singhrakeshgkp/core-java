package com.java.dsa.dp.tabulation;

import com.java.utils.ArrayUtils;
import java.util.Arrays;

public class TabulationAllConstructs {
  static String[][] getAllConstructs(String targetStr,String[] strArray){
    String[][][] table = new String[targetStr.length()+1][][];
    /*step 1 initialize array wtih null*/
    for (int i =0; i< table.length; i++){
      table[i] = new String[0][0];
    }
    /*step 2 initialize seed value with blank subarray*/
    table[0] = new String[0][0];
    //table[0][0][0] = "";

    for (int i =0; i<table.length; i++){
      for (String str : strArray){
        if ((i+str.length()) < table.length){
          String tmpStr = targetStr.substring(i,(i+str.length()));
          if (tmpStr.equalsIgnoreCase(str)){
            String[][] newCombinations = ArrayUtils.insertLastInEachSubArray(table[i],str);
            String[][] updatedCombination = ArrayUtils.mergeJaggedArrays(table[i+str.length()], newCombinations);
            table[i+str.length()] = updatedCombination;
          }
        }
      }
    }
    return table[targetStr.length()];
  }
  public static void main(String[] args) {
   String[][] combinations = getAllConstructs("abcdef",new String[]{"ab","abc","cd","def","abcd","ef","c"});
   for (String[] arr :combinations){
     System.out.println(Arrays.toString(arr));
   }
    System.out.println("second combination ===========");
    String[][] combinations2 = getAllConstructs("purple",new String[]{"purp","p","ur","le","purpl"});//-->[[purp,le][p,ur,p,le]]
    for (String[] arr :combinations2){
      System.out.println(Arrays.toString(arr));
    }
  }
}

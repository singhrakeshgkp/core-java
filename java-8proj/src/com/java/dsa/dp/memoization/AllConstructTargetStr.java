package com.java.dsa.dp.memoization;

import com.java.utils.ArrayUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllConstructTargetStr {

  static  String [][] constructStr(String targetStr,String[] words){
    if (targetStr.equals("")) return new String[0][0];
    String[][]results = new String[0][];
    for (String word : words){
      if (targetStr.indexOf(word) ==0){
        String suffix = targetStr.substring(word.length());
        String[][] ways = constructStr(suffix,words);
        ways = ArrayUtils.insertFirstInEachSubArray(word,ways);
        results = ArrayUtils.mergeJaggedArrays(results,ways);
      }
    }
    return results;
  }

  public static String[][] memoizedConstructStr(String targetStr,String[] words, Map<String,String[][]> memo){
    if (memo.containsKey(targetStr)) return memo.get(targetStr);
    if (targetStr.equals("")) return new String[0][0];
    String[][]results = new String[0][];
    for (String word : words){
      if (targetStr.indexOf(word) ==0){
        String suffix = targetStr.substring(word.length());
        String[][] ways = memoizedConstructStr(suffix,words,memo);
        ways = ArrayUtils.insertFirstInEachSubArray(word,ways);
        results = ArrayUtils.mergeJaggedArrays(results,ways);
      }
    }
    memo.put(targetStr,results);
    return results;
  }
  public static void main(String[] args) {
    String[][] allWays = constructStr("purple",new String[]{"purp","p","ur","le","purpl"});
    for (int i =0; i< allWays.length; i++){
      System.out.println(Arrays.toString(allWays[i]));
    }

    allWays = constructStr("abcdef",new String[]{"ab","abc","cd","def","abcd","ef","c"});
    for (int i =0; i< allWays.length; i++){
      System.out.println(Arrays.toString(allWays[i]));
    }
    allWays = memoizedConstructStr("aaaaaaaaaaaaaaaaaaaaaaaaad",new String[]{"a","aa","aaa","aaaa","aaaaa"},new HashMap<>());// with non memoized it will take lot of time.
    for (int i =0; i< allWays.length; i++){
      System.out.println(Arrays.toString(allWays[i]));
    }
  }
}

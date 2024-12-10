package com.java.dsa.dp.memoization;

import java.util.HashMap;

public class CountConstructTargetStr {

  /*Write a fun countConstruct(targetStr,wordArray) that accepts a target string and  word array. The fun should return
   * a number of ways we can construct the  `target` by concatenating elements of wordArray.
   * You may reuse elements of wordArray as many times as needed.
     countConstruct(abcdef,[ab,abc,cd,def,abcd])-->1
   *
   * */

  static int countConstruct(String targetStr,String[] words){
    if(targetStr.equals("")) return 1;
    int count=0;
    for (String word : words){
      if (targetStr.indexOf(word) ==0){
        String suffix = targetStr.substring(word.length());
        count += countConstruct(suffix,words);
      }
    }
    return count;
  }

  private static int memoizedCountConstruct(String targetStr, String[] words, HashMap<String, Integer> memo) {
    if(memo.containsKey(targetStr)) return  memo.get(targetStr);
    if(targetStr.equals("")) return 1;
    int count=0;
    for (String word : words){
      if (targetStr.indexOf(word) ==0){
        String suffix = targetStr.substring(word.length());
        count += memoizedCountConstruct(suffix,words,memo);
      }
    }
    memo.put(targetStr,count);
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd"}));
    System.out.println(countConstruct("purple",new String[]{"purp","p","ur","le","purpl"}));

    String inputTarget = "fffffffffffffffffffffffffffd";
    String [] elements = {"f","ff","fff","ffff"};
    //System.out.println(countConstruct(inputTarget,elements)); //will take longer time
    System.out.println(memoizedCountConstruct(inputTarget,elements,new HashMap<>()));
  }

}

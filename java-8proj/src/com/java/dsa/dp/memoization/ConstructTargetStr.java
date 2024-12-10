package com.java.dsa.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class ConstructTargetStr {

  /*Write a fun canConstruct(targetStr,wordArray) that accepts a target string and an word array. The fun should return
   * a boolean indicating whether or not the `target` can be constructed by concatenating elements of wordArray.
   * You may reuse elements of wordArray as many times as needed.
   * canConstruct(abcdef,[ab,abc,cd,def,abcd])--->True (abc+def)
   * canConstruct(skateboard,[bo,rd,ate,t,ska,boar])--->False (abc+def)
   * canConstruct('',[ram,dam,sham])--->true
   *
   * */
  static boolean canConstruct(String targetStr, String[] words) {
    if (targetStr.equals("")) {
      return true;
    }
    for (String element : words) {
      if (targetStr.indexOf(element) == 0) {
        var suffix = targetStr.substring(element.length());
        if (canConstruct(suffix, words) == true) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean memoizedCanConstruct(String targetStr, String[] words, Map<String, Boolean> memo) {
    if (memo.containsKey(targetStr)) {
      return memo.get(targetStr);
    }
    if (targetStr.equals("")) {
      return true;
    }
    for (String element : words) {
      if (targetStr.indexOf(element) == 0) {
        var suffix = targetStr.substring(element.length());
        if (memoizedCanConstruct(suffix, words,memo) == true) {
          memo.put(targetStr, true);
          return true;
        }
      }
    }
    memo.put(targetStr, false);
    return false;
  }

  public static void main(String[] args) {
    System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    ;
    System.out.println(
        canConstruct("skateboard", new String[]{"bo", "ra", "de", "def", "t", "board"}));
    ;
    System.out.println(canConstruct("", new String[]{"dfdf", "dfjd"}));
    ;
    String inputTarget = "fffffffffffffffffffffffffffd";
    String [] elements = {"f","ff","fff","ffff"};
    //System.out.println(canConstruct(inputTarget,elements)); //will take longer time
     System.out.println(memoizedCanConstruct(inputTarget,elements,new HashMap<>()));
  }
}

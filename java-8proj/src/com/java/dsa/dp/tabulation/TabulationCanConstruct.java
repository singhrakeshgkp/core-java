package com.java.dsa.dp.tabulation;

public class TabulationCanConstruct {

  static boolean canConstruct(String targetStr,String[] words){
    boolean [] table = new boolean[targetStr.length()+1];
    table[0] = true;
    for (int i =0; i< table.length; i++){
      for (String word : words){
        if((i+word.length()) < table.length) {
          String tmpString = targetStr.substring(i, (i + word.length()));
          if (tmpString.equalsIgnoreCase(word)) {
            table[i + word.length()] = true;
          }
        }
      }
    }
    return table[targetStr.length()];
  }
  public static void main(String[] args) {
    System.out.println(canConstruct("abcdef",new String[]{"ab","abc","cd","de","abcd"}));//false
    System.out.println(canConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd"}));//true
    System.out.println(canConstruct("rakesh",new String[]{"ra","rr","ke","sh","raj"}));//true

  }
}

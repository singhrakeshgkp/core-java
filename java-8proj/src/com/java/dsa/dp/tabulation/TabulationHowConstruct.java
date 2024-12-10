package com.java.dsa.dp.tabulation;

public class TabulationHowConstruct {

  static int howConstruct(String targetStr, String[] words){
    int[] table = new int[targetStr.length()+1];
    table[0] = 1;
    for (int i=0; i<table.length; i++){
      for (String word : words) {
        if ((i + word.length()) < table.length) {
          String tmpString = targetStr.substring(i, (i + word.length()));
          if (tmpString.equalsIgnoreCase(word)) {
            table[i + word.length()] += table[i];
          }
        }
      }
    }
    return table[targetStr.length()];
  }
  public static void main(String[] args) {
    System.out.println(howConstruct("purple",new String[]{"purp","p","ur","le","purpl"}));//2
    System.out.println(howConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd"}));//1
    System.out.println(howConstruct("skateboard",new String[]{"bo","rd","ate","ska","sk","boar"}));//0
    System.out.println(howConstruct("enterapotentpot",new String[]{"a","p","ent","enter","ot","o","t"}));//4
  }
}

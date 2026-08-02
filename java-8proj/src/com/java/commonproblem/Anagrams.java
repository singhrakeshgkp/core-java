package com.java.commonproblem;

import java.util.Arrays;

public class Anagrams {
/*Q. Given two string s1 and s2 check if they are anagrams
* Anagrams string made of same character with same frequency*/
  public static void main(String[] args) {
    String s1 = "garden";
    String s2 = "danger";
    System.out.println(checkIfAnagramsApproach2(s1,s2));
  }

  private static boolean checkIfAnagramsApproach1(String s1, String s2) {
    if(s1 == null  || s2 == null || s1.length() != s2.length())
      return false;
    char [] arr1 = s1.toLowerCase().toCharArray();
    char[] arr2 = s2.toLowerCase().toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    return Arrays.equals(arr1,arr2);
  }

  public static boolean checkIfAnagramsApproach2(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }

    int[] count = new int[26]; // assuming only lowercase letters
    for (int i = 0; i < s1.length(); i++) {
      count[s1.charAt(i) - 'a']++;
      count[s2.charAt(i) - 'a']--;
    }

    for (int c : count) {
      if (c != 0) return false;
    }

    return true;
  }
}

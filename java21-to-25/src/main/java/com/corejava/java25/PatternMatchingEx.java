package com.corejava.java25;

public class PatternMatchingEx {

  /*_ is unnamed variable instead of percent we can use it
  * 
  * */
  public static void main(String[] args) {
    System.out.println(getGrade(90));
    System.out.println(getGrade(20));
  }

  public static String getGrade(int percentage ){
    return switch (percentage){
      case int percent when percentage >= 80 -> "Distinction";
      case int _ when percentage >= 60 -> "First division";
      case int _ when percentage >= 40 -> "Second division";
      case int _ when percentage >= 30 -> "third division";
      case int _ when percentage < 30  -> "failed";
      default -> "not a valid value";

    };
  }
}

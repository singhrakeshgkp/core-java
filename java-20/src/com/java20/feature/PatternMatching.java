package com.java20.feature;

public class PatternMatching {

  public static void main(String[] args) {
    /*case 1 code before pattern matching*/
    /*processCase1(1);
    processCase1("hello");*/

    /*case 2 Pattern matching using instance of, here typecasting is not required*/
    /*processCase2("hello hi this is rakesh singh");*/

    /*case 3 pattern matching with switch*/
   /*System.out.println(processCase3(null));
   System.out.println(processCase3(33));
    System.out.println(processCase3("Hi this is rakesh"));*/

  /*case 4 Guarded pattern and dominance*/
    System.out.println(processCase4(20));
    System.out.println(processCase4("Hi this is rakesh"));
  }


  public static void processCase1(Object obj){
    if(obj instanceof Integer){
      System.out.println("got integer value");
    } else if (obj instanceof  String) {
      String str = (String) obj;
      System.out.println("got string length of the stirng is "+str.length());

    }
  }

  public static void processCase2(Object obj){
    if(obj instanceof Integer intValue){
      System.out.println("got integer value"+ intValue);
    } else if (obj instanceof  String str) {
      System.out.println("got string length of the stirng is "+str.length());
    }
  }

  public static String processCase3(Object obj){
    return switch (obj){
      case null-> "got null which is not expected";
      case Integer i-> "Got integer type";
      case String str-> "got string, string length is "+str.length();
      default -> "default case called";
    };
  }

  public static String processCase4(Object obj){
    return switch (obj){
      case Integer i when i==20 -> "got 20";
      case Integer i-> "Got integer type";
      case String str-> "got string, string length is "+str.length();
      default -> "default case called";
    };
  }
}

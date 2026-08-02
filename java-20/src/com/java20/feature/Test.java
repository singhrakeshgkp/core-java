package com.java20.feature;

public class Test {


  public static void main(String[] args) {
    /*1. Evolution of switch
    * 2. Text Block
    * 3. Record
    * 4. Sealed classes
    * 5. Pattern matching*/

    /*Pattern matching*/
    /*1. before pattern matching
    * 2. pattern matching using instance of
    * 3. Pattern matching using switch*/
    System.out.println(process(88l));;
  }

  public static String process(Object object){
   return switch (object){
     case null -> "null is not valid input";
     case Integer i-> "got integer "+i;
     case String str -> "got String type "+str;
     default -> "please enter valid type";
   };
  }
}


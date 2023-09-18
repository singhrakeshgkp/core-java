package com.java.lambda;

import java.util.Arrays;

import java.util.List;
import static java.util.stream.Collectors.*;

public class LambdaTest12 {
    
public static void main(String[] args) {
    
    sized();  // sized, ordered, not distinct, unsorted
   distinct();
   sorted();

}


public static void distinct() {
  
    List<Integer> numbers = Arrays.asList(4,5,6,7,8,4,5,6,7,8);
    System.out.println("Distinct List is "+
    numbers.stream()
    	   .distinct()
    	   .filter(e->e%2 ==0)
    	   .collect(toList()));
   
}

public static void sized() {
    
    List<Integer> numbers = Arrays.asList(4,5,6,7,8,4,5,6,7,8);
    System.out.println("List is "+
    numbers.stream()
    	   .filter(e->e%2 ==0)
    	   .collect(toList()));
   
}

public static void sorted() {
    
    List<Integer> numbers = Arrays.asList(4,5,6,7,8,4,5,6,7,8);
    System.out.println("sorted List is "+
    numbers.stream()
    	   .sorted()
    	   .filter(e->e%2 ==0)
    	   .collect(toList()));
   
}

}

package com.java.lambda;

import java.util.stream.Stream;

public class LambdaTest13 {
   /*Infinite Stream
    * Problem -> given a number k, and a count n, find the double of n even numbers
    *            starting with k, where sqrt of each number is >20
    *  
    * 
    * 
    * */  
public static void main(String[] args) {
    
  int k = 121;
  int n =51;
  int resultFromImpe =  imprativeWay(k,n);
  int resultFromFun =  functionalWay(k,n);
  
  System.out.println("Imperative results "+resultFromImpe);
  System.out.println("functinal results "+resultFromFun);

}


public static int imprativeWay(int k, int n) {
    int result =0;
    int index = k;
    int count =0;
    count = 0;
    
  while(count < n) {
  if(index%2 == 0 && Math.sqrt(index)>20) {
     result += index*2; 
     count++;
  }
  
  index++;
  }
  return result;
}

public static int functionalWay(int k, int n) {
   
  return Stream.iterate(k, e->e+1)//unbounded, lazy
   	 .filter(e->e%2 == 0)     // unbounded, lazy
   	 .filter(e-> Math.sqrt(e)>20)// unbounded, lazy
   	 .mapToInt(e->e*2)           // unbounded, lazy
   	 .limit(n)                  // sized,lazy
   	 .sum();                 
 }
}

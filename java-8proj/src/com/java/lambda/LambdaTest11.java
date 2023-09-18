package com.java.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest11 {
	
/* 
 * Collectors
 *-> Grouping
 *Problem1 -> Given a list of number find double of first even number which is >3
 *Solution -> 
 *         functionalAppproach1() -> is recommended
 *         functionalApproach2() and ImperativeApproach is not recommended
 *           
 * */
	
    
public static void main(String[] args) {
    
    imperativeApproach(); 
    /*efficiency-> 
     * 1. 1>3 false
     * 2. 2 >3 false
     * 3. 3>3 false
     * 4. 4>3 true and 4%2==0 true
     *Unit of work = 4 
     * 
     * */
    functionalApproach1();
    
    functionalApproach2();
    /*efficiency for both functionalApproach1 && functionalApproach2 is same
     * 1. 1>3
     * ...
     * 4..
     * Unit of work 4 as stream apply all the operation on each element one by one not entire collection in one go
     * 
     * */

}




public static void imperativeApproach() {
  
    List<Integer> numbers = Arrays.asList(1,2,3,5,4,6,7,8,9,10,11,12,13,14,16,15,18,17,20);
    int result = 0;
    for (int num : numbers) {
	if(num>3 && num%2 == 0) {
	    result = num*2;
	    break;
	}
    }
    
    System.out.println("result from Imperative method "+result);
}

public static void functionalApproach1() {
    
   List<Integer> numbers = Arrays.asList(1,2,3,5,4,6,7,8,9,10,11,12,13,14,16,15,18,17,20);
   System.out.println("result form fun Approach1 "+
    numbers.stream()
    	   .filter(e->e>3)
    	   .filter(e->e%2 == 0)
    	   .map(e->e*2)
    	   .findFirst());
}

public static void functionalApproach2() {
   
    List<Integer> numbers = Arrays.asList(1,2,3,5,4,6,7,8,9,10,11,12,13,14,16,15,18,17,20);
    System.out.println("result form fun Approach1 "+
     numbers.stream()
     	   .filter(LambdaTest11::isGreaterThan)
     	   .filter(LambdaTest11::isEven)
     	   .map(LambdaTest11::doubleTheNum)
     	   .findFirst());
}

public static boolean isGreaterThan(int num) {
    System.out.println("isGreaterThan 3"+num);
    return num>3?true:false;
}

public static boolean isEven(int num) {
    System.out.println("isEven "+num);
    return num%2 == 0;
}

public static int doubleTheNum(int num) {
    System.out.println("double "+num);
    return num*2;
}

}

package com.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaVSClosures1 {

    /*Task 1 - Double the number and calculate its sum
     * output - 4+6+8=18
     *Task 2- same task1- with final variable
     * output - compilation error
     * 
     *Task 3 Cheating java for function purity(immutability) using array index
     *output - 0,0,0 since it support lazy evaluation
     * 
     * */
    public static void fun1() {
	
	List<Integer> numbers = Arrays.asList(2,3,4);
	numbers.stream()
	.map(e->e*2)
	.forEach(System.out::println);
    }
    
   
    
    
public static void fun2() {
	int factor = 3;  //effectively final
	List<Integer> numbers = Arrays.asList(2,3,4);
	numbers.stream()
	.map(e->e*factor)
	.forEach(System.out::println);
	
	//This lambda has to be close-over if defining scope looking for the variable factor to bind to closure
	//Lambda are stateless 
	//closure has (immutable state)
       //factor = 4;  this is not allowed
    }

    public static void fun3() {
    	
    	List<Integer> numbers = Arrays.asList(2,3,4);
    	int[] factor = new int[] {3};
    	Stream<Integer> stream = numbers.stream()
    		                 .map(e->e*factor[0]);//bad practice should not include var which is changing 
    	factor[0]= 0;
    	stream.forEach(System.out::println);
    	
    	
    	
    	
       }
    
    public static void main(String[] args) {
	//fun1();
	//fun2();
	fun3();
    }
}

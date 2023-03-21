package com.designpattern.addconc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LightweightStrategyPattern {

    /*Problem-> Suppose we have a collection of numbers, may be price of stock, product etc.
     * you are asked to write a method to total all values.
     * Solution->fun1 using imperative style
     * Now you have been asked to total even number
     * Solution-> you write another function that is funEven1
     * Now again you have been asked to get total of odd numbers value
     * solution-> you write another function that is funOdd1
     * to avoid code duplicate we can define some strategy implemented using fun2
     * 
     * */
    
    public static int fun1() {
	var numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	var total =0;
	for(int num : numbers) {
	    total += num;
	}
	return total;
    }
    
    public static int funEven1(List<Integer> numbers) {
	var total =0;
	for(int num : numbers) {
	    if(num %2 == 0) {
	    total += num;
	    }
	}
	return total;
    }
    
    public static int funOdd1(List<Integer> numbers) {
	var total =0;
	for(int num : numbers) {
	    if(num %2 != 0) {
	    total += num;
	    }
	}
	return total;
    }
    
    public static int fun2(List<Integer> numbers, Predicate<Integer> selector) {
	
	return numbers.stream()
		.filter(selector)
		.mapToInt(e->e)
		.sum();
	
    }
    
    public static boolean isOdd(int number) {
	
	return number%2 !=0;
    
}
    public static void main(String[] args) {
	var numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	System.out.println("total "+fun2(numbers,ignore->true));
	System.out.println("total of even numbers "+fun2(numbers,number->number%2==0));
	System.out.println("total of odd numbers "+fun2(numbers,LightweightStrategyPattern::isOdd));
    }
}

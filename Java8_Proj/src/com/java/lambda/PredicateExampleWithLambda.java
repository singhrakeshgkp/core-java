package com.java.lambda;

import java.util.function.Predicate;

public class PredicateExampleWithLambda {

	//predicate example with test function
	public static boolean ex1PredicateTestEvenOdd() {
		Predicate<Integer> predicate = (t) -> t%2 ==0;
		return predicate.test(5);
	}
	
	// 
	
	public static void main(String[] args) {
		System.out.println(ex1PredicateTestEvenOdd());
	}
}

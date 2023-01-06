package com.java.generics;

@FunctionalInterface
interface Calculator<T extends Number>{
	T sum(T t1, T t2);
}

@FunctionalInterface
interface Calculator2<R>{
	<V> Calculator2<R> sum();
}
public class UpperAndLowerBoundTest {

	
	public static void main(String[] args) {
		
		/* 1. upper Bound 
		Calculator<Integer> cal = (t1,t2) -> t1+t2;
		System.out.println(cal.sum(10, 12));
		*/
		
		// 2. Lower Bound 
		Calculator<Integer> cal = (t1,t2) -> t1+t2;
		System.out.println(cal.sum(10, 12));
		
	}
}

package com.java.generics;

public class GenericTest {

	public static void main(String[] args) {
		
	
	}
	
	
}

class CalculatorTest{
	
	public <T extends Number> double sum(T t1, T t2) {
		return t1.doubleValue()+t2.doubleValue();
	}
}
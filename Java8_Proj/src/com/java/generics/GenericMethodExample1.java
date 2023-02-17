package com.java.generics;

import java.util.Arrays;
import java.util.List;

public class GenericMethodExample1 {

	/*
	 * <T> -  Generic type
	 * List<T> Return type
	 * 
	 **/
	public static <T> List<T> fromArrayToList(T[]array){
		return Arrays.asList(array);
	}
	
	public static void main(String[] args) {
		
		String[] strArray = "a,b,c,d,f".split(",");
		GenericMethodExample1.<String>fromArrayToList(strArray).forEach(s->System.out.println(s));;
	}
}

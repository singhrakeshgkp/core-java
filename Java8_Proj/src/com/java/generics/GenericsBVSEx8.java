package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsBVSEx8 {

    /* 1. Print the numbers-> it will run successfully
     * 2. now create new function-> it will give runtime exception
     * */
    
    
    public static void main(String[] args) {
	
	List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3));
	msg(numbers);
	numbers.forEach(System.out::println);
	
	
    }
    
    public static void msg(List list) {
	list.add("hello");
	
    }
    
}


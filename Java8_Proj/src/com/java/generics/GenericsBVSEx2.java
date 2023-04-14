package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsBVSEx2 {

    /*Task1 create a function to copy the collection
     * 
     * */
    public static void main(String[] args) {
	List<Integer> num1List = new ArrayList<>(Arrays.asList(1,2,3));
	List<Integer> num2List = new ArrayList<>(Arrays.asList(4,5,6));
	copy(num1List, num2List);
	System.out.println(num2List);
    }
    
    public static <T> void copy(List<T> from, List<T> to) {
	
	for(var e : from) {
	    to.add(e);
	}
    }
}

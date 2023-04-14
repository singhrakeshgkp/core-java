package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsBVSEx3 {

    /*Task Create a generic function that copy all the elements except the given one
     *Solution- if(e.compareTo(exclude) !=0) This is not possible(without constraints), you can apply compareTo on any
     *arbitrary type so here constraints need to be placed on generic type.
     *without constraints on type parameter if will give compile time error
     *
     *After adding constraints it will run and produce the desired output
     *T extends Comparable<T> :- here extends doesn't mean extends, it simply means its in the
     *bottom of hierarchy of inheritance tree.
     *
     T extends Comparable<T> :- it means you can not pass any arbitrary that doen't implements comparable
     * 
     * */
    public static void main(String[] args) {
	List<Integer> num1List = new ArrayList<>(Arrays.asList(1,2,3));
	List<Integer> num2List = new ArrayList<>(Arrays.asList(4,5,6));
	copyAllBut(num1List, num2List,2);
	System.out.println(num2List);
    }
    
    public static <T extends Comparable<T>> void copyAllBut(List<T> from, List<T> to,T exclude) {
	
	for(var e : from) {
	   if(e.compareTo(exclude) !=0)
	    to.add(e);
	}
    }
}

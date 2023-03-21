package com.designpattern.addconc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1. fun1()-> External Iterator
 *2. fun()2-> Internal Iterator
 * 
 * 
*/
public class IteratorPattern1 {

    public static void fun1() {
	var names = Arrays.asList("rakesh","sumit","raghvendra");
	var result = new ArrayList<>();
	
	for(int i =0; i<names.size(); i++) {
	   if(names.get(i).length()>5) {
	       result.add(names.get(i).toUpperCase());
	   }
	}
   System.out.println(result);
    }
    
 public static void fun2() {
     
     var names = Arrays.asList("rakesh","sumit","raghvendra");
     var result1 = new ArrayList<>();
     names.parallelStream()
     	  .filter(name->name.length()>5)
     	  .map(name->name.toUpperCase())
     	  .forEach(name->result1.add(name));// bad idea mutating data of result1, in will fail in parallel stream
                                            //functional pipeline is not pure because of shared mutability
     System.out.println(result1);
	
 }
    public static void main(String[] args) {
	//fun1();
	fun2();
    }
}

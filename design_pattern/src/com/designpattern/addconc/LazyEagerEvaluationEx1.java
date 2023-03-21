package com.designpattern.addconc;

import java.util.function.Supplier;

public class LazyEagerEvaluationEx1 {
    /*1. fun1()-> Example of Short Circuiting that is if first condition is false second will not be evaluated
     *2. fun2()-> Example of eager evaluation(calling function even not using its result) 
     *3. fun3()->
     * 
     * 
     * */
    
    public static int compute(int num) {
	System.out.println("in compute");
	return num*100;
    }
    public static void fun1() {
	int value = 4;
	if(value>4 && compute(value)>100) {
	    System.out.println("in path one");
	}else {
	    System.out.println("in path two");
	}
    }
    
    public static void fun2() {
   	int value = 40;
   	int result = compute(value);// eager evaluation not using the result but function is being called
   	if(value>4 && compute(value)>100) {
   	    System.out.println("in path one");
   	}else {
   	    System.out.println("in path two");
   	}
       }
    
    
    public static void fun3() {
	
     /* David Wheeler-> In CS we can solve almost any problem by introducing one more level of indirection
      *    In Procedural code, such as c++ pointers gave the power of indirection
      *    In OOPS code, overriding functions gave the power of indirection
      *    In Function programming Lambda gave the power of indirection
      * */
   	int value = 4;
   	Lazy<Integer> result = new Lazy<>(()->compute(value));
   	if(value>4 && result.get()>100) {
   	    System.out.println("in path one result "+result.get());
   	}else {
   	    System.out.println("in path two");
   	}
       }
    public static void main(String[] args) {
	//fun1();
	//fun2();
	
	fun3();
    }
}




class Lazy<T>{
    private T instance;
    private Supplier<T> supplier;
    public Lazy(Supplier<T> supplier) {
	this.supplier = supplier;
    }
    
    public T get() {
	if(instance == null) {
	   instance = supplier.get();
	}
	return instance;
    }
}

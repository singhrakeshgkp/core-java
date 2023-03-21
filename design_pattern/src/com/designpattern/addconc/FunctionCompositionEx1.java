package com.designpattern.addconc;

import java.util.function.Function;

public class FunctionCompositionEx1 {

    /*Task 1-> apply inc operation and print its result
     *Task 2 -> apply doubled operation and print its result
     *Task 3-> apply inc and doubled operation one by one and print its result
     * 
     * 
     * */
    
    public static void print(int number, String msg,
	    Function<Integer, Integer> fun) {
	System.out.println(number+" msg "+ msg+" "+fun.apply(number));
	
    }
    public static void main(String[] args) {
	
	Function<Integer, Integer> fun = (num)->num+1;
	Function<Integer, Integer> doubledFun = (num)->num*2;
	print(5, "Incremented operation", fun);
	print(5, "doubled operation", doubledFun);
	
	//print(5, "incremented and doubled operation", value->(value+1)*2);// not good idea,function comp can we used  here
	/*
	 * inc---|incremented|----> 
	 * doubled -----|doubled|----->
	 * combined
	 * -->|-->|inc|-->|doubled|--->|----->
	 * 
	 * 
	 * */
	
	print(5, "doubled operation", fun.andThen(doubledFun));
	
	
    }
}

package com.designpattern.addconc;

import java.util.Optional;

/*1. getName1 -> Not recommended, bad idea
 *2. getName2-> Recommended
 * 
 * */
public class OptionalPattern1 {

    public static String getName1() {
	return null;//not good idea
    }
    
    public static Optional<String> getName2(){
	if(Math.random()>0.5)
	    return Optional.of("rakesh");
	else
	return Optional.empty();//recommended way
    }
    public static void main(String[] args) {
	
	var result = getName2();
	System.out.println(result.orElse("not available"));
	//result.get() -> this is also not recommended, it will blow up if object doesn't exit
	
	
    }
}

package com.designpattern.addconc;

public class ExecuteAroundMethodPattern1 {

    /*1. fun2()1 -> using finalize, but its not get called as there is enough memory
     *2. fun2() -> create new close method, it will be called but what if there was an exception
     *3. fun3()-> you could use try catch and finally -> its also not good idea reason is given below
     *   3.1-> Code is verbose
     *   3.2-> Easy to forget to call try and finally so
     *4.-> ARM(Automatic resource management)-> try with resource, also not good idea
     *5. refer code{ExecuteAroundMethodPattern2}
     * 
     * */
    
    public static void fun1() {
	Resource resource = new Resource();
	resource.op1();
	resource.op2();
	//finalize not called because there is a lot of memory there is no reason to call it
	System.gc(); 
    }
    
    public static void fun2() {
	Resource resource = new Resource();
	resource.op1();
	resource.op2();
	resource.close();
    }
    
    public static void fun3() {
	
	Resource resource = new Resource();
	try {
		resource.op1();
		resource.op2();
	    
	}finally {
	    resource.close();
	}
    }
    public static void main(String[] args) {
	
	//fun1();
	//fun2();
	fun3();
	
    }
}

class Resource{
    
    public Resource() {
	System.out.println("object created");
    }
    
    public Resource op1() {
	System.out.println("op1.....");
	return this;
    }
    
    public Resource op2() {
	
	System.out.println("op2...");
	return this;
    }
    
    public void finalize() {
	System.out.println("release external resources");
    }
    
    public void close() {
	System.out.println("close called release external resources");
    }
}

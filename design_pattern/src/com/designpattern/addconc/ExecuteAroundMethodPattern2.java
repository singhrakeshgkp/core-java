package com.designpattern.addconc;

import java.util.function.Consumer;

public class ExecuteAroundMethodPattern2 {

    /*
     *5. make the resource constructor as private, make close method private as well
     *  5.1->Execute Around Method-> with a before and after part
     *      This is more of a civilized AOP
     * 
     * */
    
   
    
    public static void fun2() {
	Resource resource = new Resource();
	resource.op1();
	resource.op2();
	resource.close();
    }
    
    
    public static void main(String[] args) {
	Resource2.use(resource->resource.op1().op2());
    }
}

class Resource2{
    
    private Resource2() {
	System.out.println("object created");
    }
    
    public Resource2 op1() {
	System.out.println("op1.....");
	return this;
    }
    
    public Resource2 op2() {
	
	System.out.println("op2...");
	return this;
    }
    
  
    private void close() {
	System.out.println("close called release external resources");
    }
    
    public static void use(Consumer<Resource2> block) {
	Resource2 resource = new Resource2();//before
	try {
	    block.accept(resource);
	}finally {
	    resource.close();//after
	    
	}
    }
}

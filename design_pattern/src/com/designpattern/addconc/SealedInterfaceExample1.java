package com.designpattern.addconc;

public class SealedInterfaceExample1 {

    /*Useful if u don't want your interface to be implemented by client
     * in sts sealed keyword won't work, use command line 
     * */
    
    public static void main(String[] args) {
	
	TrafficLight light = new RedLight();
	System.out.println(light);
    }
}
 
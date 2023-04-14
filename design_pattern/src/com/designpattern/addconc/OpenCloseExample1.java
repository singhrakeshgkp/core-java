package com.designpattern.addconc;

public class OpenCloseExample1 {

    /*Task 1-> try to copy using copy constructor, as java do not provide copy constructor
     *         the code will complain and fail to compile line 13,14
     * 
     * */
    public static void main(String[] args) {
	Car1 carObj1 = new Car1(2015, new Engine1());
	System.out.println(carObj1);
	
    //	Car1 carObj2 = new Car1(carObj1);//compile time error as java does not provide copy constructor
    //System.out.println(carObj2);
    }
}

class Engine1{
    public String toString() {
	return getClass().getName()+":"+hashCode();
    }
}
class Car1{
    
    private int year;
    private Engine1 engine;
   
    public Car1(int year, Engine1 engine) {
	super();
	this.year = year;
	this.engine = engine;
    }
    
    public String toString() {
	return year+"_"+engine;
    }
    
    
    
}

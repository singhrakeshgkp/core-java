package com.designpattern.addconc;

public class OpenCloseExample2 {

    /*Task 2 step 1-> try to copy using explicit copy constructor
     * this will also not work as we don't want to copy the engine we want copy of engine.
     * we want deep copy not a shallow copy.
     * 
     * Step 2- Create a Copy constructor for engine
     * 
     * 
     * */
    public static void main(String[] args) {
	Car2 carObj1 = new Car2(2015, new Engine2());
	System.out.println(carObj1);
	
    	Car2 carObj2 = new Car2(carObj1);
       System.out.println(carObj2);
    }
}

class Engine2{
   
    /*step 2 start*/
    public Engine2() {};
    public Engine2(Engine2 engine) {};
    
    /*step 2 end*/
    
    public String toString() {
	return getClass().getName()+":"+hashCode();
    }
}
class Car2{
    
    private int year;
    private Engine2 engine;
   
    public Car2(int year, Engine2 engine) {
	super();
	this.year = year;
	this.engine = engine;
    }
    
    public Car2(Car2 car) {
	this.year = car.year;
	//step 2 start
	this.engine = new Engine2(car.engine);
	
	//step 2 end
    }
    
    public String toString() {
	return year+"_"+engine;
    }
    
    
    
}

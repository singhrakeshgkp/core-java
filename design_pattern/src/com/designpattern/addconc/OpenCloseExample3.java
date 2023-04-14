package com.designpattern.addconc;

public class OpenCloseExample3 {

    /*Task 3 over the time requirement has changed now client asked we needed new kind of engine
     * such as turbo engine
     * 
     * Solution-> . Create Turbo engine class extending Engine class, provide copy constructor
     *               run the application. it will run and print the result on console.
     * Task 4-> Now change Car3 carObj1 = new Car3(2015, new Engine3()) to TurboEngine3
     * and if you run the application you will observe first car has Turbo engine and second one Engine
     * which is not correct. As in java, c++ or C# new is not polymorphic
     * Solution->  modify the Car3(Car3 car) constructor.
     *             this time it will produce the correct response
     *             but this is not good practice.
     *             it is example of failure of open close principle,why? answer is because the 
     *             only way one can accommodate new engine is by changing the Car3(Car3 car)
     *             constructor.
     *             for fix refer OpenCloseExample4.java
     * 
     * 
     * */
    public static void main(String[] args) {
	Car3 carObj1 = new Car3(2015, new TurboEngine3());//Car3(2015, new Engine3());// changed from Engine3() to new TurboEngine3()
	System.out.println(carObj1);
	
    	Car3 carObj2 = new Car3(carObj1);
       System.out.println(carObj2);
    }
}


class Car3{
    
    private int year;
    private Engine3 engine;
   
    public Car3(int year, Engine3 engine) {
	super();
	this.year = year;
	this.engine = engine;
    }
    
    public Car3(Car3 car) {
	
	/* existing code
	this.year = car.year;
	this.engine = new Engine3(car.engine);
	*/
	/*New code after modification*/
	this.year = car.year;
	if(car.engine instanceof TurboEngine3) {
	    engine = (TurboEngine3)car.engine;
	}else {
	    
	    this.engine = new Engine3(car.engine);
	}
	
	
	
	
    }
    
    public String toString() {
	return year+"_"+engine;
    }
  
}


class Engine3{
   
    
    public Engine3() {};
    public Engine3(Engine3 engine) {};
    
    
    
    public String toString() {
	return getClass().getName()+":"+hashCode();
    }
}

class TurboEngine3 extends Engine3{
    public TurboEngine3() {super();};
    public TurboEngine3(TurboEngine3 engine) {
	super(engine);
    }
}

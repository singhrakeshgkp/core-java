package com.designpattern.addconc;

public class OpenCloseExample4 {

    /*if you want new kind of engine extend the engine class which is fine but don't change car 
     * class. this is what OCP principle says.
     * 
     * Solution 1. make the engine constructor protected
     *          2. create copy method which is polymorphic
     *          
     * Issue with this design-> Here we are violating Dry principle, every time we have to introduce
     * new type of engine we have to write copy method.
     * 
     * Solution-> use the reflection in Engine4 copy method to copy the object and remove copy from other classess
     * 
     * 
     * */
    public static void main(String[] args) {
	Car4 carObj1 = new Car4(2015, new TurboEngine4());
	System.out.println(carObj1);
	
    	Car4 carObj2 = new Car4(carObj1);
       System.out.println(carObj2);
    }
}


class Car4{
    
    private int year;
    private Engine4 engine;
   
    public Car4(int year, Engine4 engine) {
	super();
	this.year = year;
	this.engine = engine;
    }
    
    public Car4(Car4 car) {
	
	
	this.year = car.year;
	this.engine = car.engine.copy();
	
    }
    
    public String toString() {
	return year+"_"+engine;
    }
  
}


class Engine4{
    public Engine4() {};

protected Engine4(Engine4 engine) {};
public Engine4 copy() {
    //Reflection can be used to avoid Dry principle issue
    return new Engine4(this);
}
    
    
    public String toString() {
	return getClass().getName()+":"+hashCode();
    }
}

class TurboEngine4 extends Engine4{
    public TurboEngine4() {super();};
    public TurboEngine4(TurboEngine4 engine) {
	super(engine);
    }
    
    public Engine4 copy() {
	    return new TurboEngine4(this);
	}
	  
}

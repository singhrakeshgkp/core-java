package com.designpattern.addconc;

public class OpenCloseExample5 {

    /*
     * Extensible-> its fine if we want another type of engine.
     * but what if Car want to have two engines.
     * Tough luck i can not provide this without changing car class. in another word a class is not
     * infinitely extensible. its only extensible for what you designed for
     * 
     * Extensibility has also problem, it increases the complexity. 
     * 
     * who can make code extensible?
     * we need to know software and domain.
     * there are three kind of people we work with
     * 1. know the domain really well, don't know software.
     * 2. knows no domain, know software really well
     * 3. know domain really well and know software really well (very few people)
     * 
     * Suggestion-> don't implement extensibility if you don't know, you can go to domain expert and
     *              ask about extensibility if he says yes it will be now implement it else postpone it.
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

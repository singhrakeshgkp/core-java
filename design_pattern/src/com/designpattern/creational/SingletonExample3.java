package com.designpattern.creational;

public class SingletonExample3 {

	public static void main(String[] args) {

		SingletonDemo3 obj1 = SingletonDemo3.getInstance();
		SingletonDemo3 obj2 = SingletonDemo3.getInstance();
		System.out.println(obj1==obj2);
	}
}

class SingletonDemo3 {
	
	private static SingletonDemo3 instance;

	private SingletonDemo3() {

	}
	
	

	public static SingletonDemo3 getInstance() {
		
		if(instance == null)
			instance = new SingletonDemo3();
		return instance;
	}


}

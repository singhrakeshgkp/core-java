package com.designpattern.creational;

public class SingletonExample4 {

	public static void main(String[] args) {

		SingletonDemo4 obj1 = SingletonDemo4.getInstance();
		SingletonDemo4 obj2 = SingletonDemo4.getInstance();
		System.out.println(obj1==obj2);
	}
}

class SingletonDemo4 {
	
	private static SingletonDemo4 instance;

	private SingletonDemo4() {

	}
	
	

	public static synchronized SingletonDemo4 getInstance() {
		
		if(instance == null)
			instance = new SingletonDemo4();
		return instance;
	}


}

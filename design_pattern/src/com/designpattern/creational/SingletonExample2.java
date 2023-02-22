package com.designpattern.creational;

public class SingletonExample2 {

	public static void main(String[] args) {

		SingletonDemo2 obj1 = SingletonDemo2.getInstance();
		SingletonDemo2 obj2 = SingletonDemo2.getInstance();
		System.out.println(obj1==obj2);
	}
}

class SingletonDemo2 {
	
	private static SingletonDemo2 instance;

	static {
		try {
			instance = new SingletonDemo2();
		}catch(Exception ex) {
			System.out.println("exception occurred "+ex.getMessage());
		}
	}
	private SingletonDemo2() {

	}
	
	

	public static SingletonDemo2 getInstance() {
		return instance;
	}


}

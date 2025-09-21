package com.designpattern.creational.singleton;

public class SingletonExample1 {

	public static void main(String[] args) {

		SingletonDemo1 obj1 = SingletonDemo1.getInstance();
		SingletonDemo1 obj2 = SingletonDemo1.getInstance();
		System.out.println(obj1==obj2);
	}
}

class SingletonDemo1 {
	
	private static SingletonDemo1 instance = new SingletonDemo1();

	private SingletonDemo1() {

	}

	public static SingletonDemo1 getInstance() {
		return instance;
	}


}

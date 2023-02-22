package com.designpattern.creational;

public class SingletonExample5 {

	public static void main(String[] args) {
		
		SingletonDemo5 obj1 = SingletonDemo5.getInstance();
		SingletonDemo5 obj2 = SingletonDemo5.getInstance();
		
		System.out.println(obj1==obj2);
		
	}
}

class SingletonDemo5 {

	private SingletonDemo5() {

	}

	private static class SingleInstance {
		private static final SingletonDemo5 INSTANCE = new SingletonDemo5();

	}

	public static SingletonDemo5 getInstance() {
		return SingleInstance.INSTANCE;
	}

}

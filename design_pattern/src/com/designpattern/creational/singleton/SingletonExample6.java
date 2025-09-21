package com.designpattern.creational.singleton;

public class SingletonExample6 {

	public static void main(String[] args) {
		
		SingletonDemo6 obj1 = SingletonDemo6.INSTANCE;
				SingletonDemo6 obj2 = SingletonDemo6.INSTANCE;
		
		System.out.println(obj1==obj2);
		obj1.msg();
		
	}
}

enum SingletonDemo6 {
	
	INSTANCE;
	public  void  msg() {
		System.out.println("enum singleton msg");
	}
}

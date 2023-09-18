package com.java.methodandreference;


public class MethodReferenceExample {

	/*1. Reference to a static method.
	 *2. Reference to an instance method.
	 *3. Reference to a constructor 
	 * */
	
	public static void main(String[] args) {
		/* 1. Method Reference To static method */
		/*
		 * Greet greet = MethodReferenceEx::greetings;
		 *  greet.greetings();
		 */
		
		/*2. Method Reference - To non  static method*/
	    /* NonStaticMethodReferenceEx nonStaticEx = new NonStaticMethodReferenceEx();
	     Greet greet = nonStaticEx::greetings;
	     greet.greetings();
	     */
	  /*3. Constructor Reference - Referring constructor*/
		Greetable greet = ConstructorReference::new;
		greet.greet("Hello world");
		
		
		
	}
}

interface Greet{
	 void greetings();
}

class StaticMethodReferenceEx {

	
	public static void greetings() {
		System.out.println("Hello! this is our first method reference program");
		
	}
}
class NonStaticMethodReferenceEx {

		
		public  void greetings() {
			System.out.println("Hello! this is our first non static method reference program");
			
		}
	
}

interface Greetable{
	ConstructorReference greet(String str);
}

class ConstructorReference{
	
	public ConstructorReference(String str) {
		System.out.println("Constructor reference:- "+str);
	}
}

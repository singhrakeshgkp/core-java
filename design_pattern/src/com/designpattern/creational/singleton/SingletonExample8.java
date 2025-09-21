package com.designpattern.creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonExample8 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		SingletonDemo8 obj1 = SingletonDemo8.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton7.ser"));
		oos.writeObject(obj1);
		oos.close();
		ObjectInputStream oIS = new ObjectInputStream(new FileInputStream("singleton7.ser"));
		SingletonDemo8 obj2 = (SingletonDemo8) oIS.readObject();
		oIS.close();
		System.out.println(obj1);
		System.out.println(obj2);
		
		
		
		
		
	
	
	}
}

 class SingletonDemo8 implements Serializable{

	
	private static final long serialVersionUID = -7033388574953074587L;

		private SingletonDemo8() {

		}

		private static class SingleInstance {
			private static final SingletonDemo8 INSTANCE = new SingletonDemo8();

		}

		public static SingletonDemo8 getInstance() {
			return SingleInstance.INSTANCE;
		}
		
	  protected Object readResolve() {
		  return getInstance();
	  }

}

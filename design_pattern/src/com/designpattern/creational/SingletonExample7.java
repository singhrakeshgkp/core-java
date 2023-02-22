package com.designpattern.creational;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonExample7 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		SingletonDemo7 obj1 = SingletonDemo7.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton7.ser"));
		oos.writeObject(obj1);
		oos.close();
		ObjectInputStream oIS = new ObjectInputStream(new FileInputStream("singleton7.ser"));
		SingletonDemo7 obj2 = (SingletonDemo7) oIS.readObject();
		oIS.close();
		System.out.println(obj1);
		System.out.println(obj2);
		
		
		
		
		
	
	
	}
}

 class SingletonDemo7 implements Serializable{

	
	private static final long serialVersionUID = -7033388574953074587L;

		private SingletonDemo7() {

		}

		private static class SingleInstance {
			private static final SingletonDemo7 INSTANCE = new SingletonDemo7();

		}

		public static SingletonDemo7 getInstance() {
			return SingleInstance.INSTANCE;
		}

}

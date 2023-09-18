package com.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsBVSEx1 {

    /*Generics solves the following problems
     *1. we used object while iterating that is smell
     *2. if we add 2.0 it will results in ClassCastException
     *3. Run time failure
     * 
     * */
    public static void main(String[] args) {
			List numbers = new ArrayList();
			numbers.add(1);
			numbers.add(2);
			//numbers.add(2.0);

			int sum = 0;
			for (Object o : numbers) {
				sum += (int) o;
			}

			System.out.println(sum);
		}
}

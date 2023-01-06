package com.java.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/*Possible way to declare lambda expression
* 1. (parameters)->expression;
* 2. (parameters)-> {statements;}
* 3. ()-> expression;
* */
public class BiConsumerExampleWithLambda {

	public static void ex1IteratingMap() {
		Map<String, String> map = new HashMap<>();
		map.put("001", "rakesh");
		map.put("002", "rohan");
		BiConsumer<String, String> biConsumer = (t, u) ->System.out.println("Key: is "+t+" value is , "+u);
		map.forEach(biConsumer);
	}
	public static void main(String[] args) {
		//ex1IteratingMap();
		
	}
}

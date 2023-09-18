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

	// Iterate the map
	public static void ex1IteratingMap() {
		Map<String, String> map = new HashMap<>();
		map.put("001", "rakesh");
		map.put("002", "rohan");
		BiConsumer<String, String> biConsumer = (t, u) ->System.out.println("Key: is "+t+" value is , "+u);
		map.forEach(biConsumer);
	}
	//Compare two account Number
	public static void ex2CompareTwoAccNumber() {
		String accountNumber1 = "xxxx1234";
		String accountNumber2 = "xxxxxxxxx12388884";
		BiConsumer<String, String> action = (acc1,acc2)->{
			String acc1LastFour = accountNumber1.substring(accountNumber1.length()-4);
			String acc2LastFour = accountNumber2.substring(accountNumber2.length()-4);
			if(acc1LastFour.equals(acc2LastFour)) {
				System.out.println("true");
			}else {
				System.out.println(acc1LastFour+", "+acc2LastFour);
				System.out.println("false");
			}
			
		
		};
		
		action.accept(accountNumber1, accountNumber2);
	}
	
  // andThen Compound operation
	public static void ex3AndThenOperation() {
		
		BiConsumer<String, String> biConsumerObj1 = (t,u)->System.out.println(t.toUpperCase()+ u.toUpperCase());
		BiConsumer<String, String> biConsumerObj2 = (t,u)->System.out.println(t.toUpperCase()+ u.toUpperCase());
		biConsumerObj1.andThen(biConsumerObj2).accept("go", "went");

	}
	
	 // andThen Compound operation
		public static void ex4AndThenOperation() {
			
			BiConsumer<Integer, Integer> biConsumerAddOperation = (t,u)->{
				int sum =t+u;
				System.out.println("sum is :- "+sum);
				};
				BiConsumer<Integer, Integer> biConsumerDivideOperation = (t,u)->{
					int result =t/u;
					System.out.println("result is :- "+result);
					};
					biConsumerAddOperation.andThen(biConsumerDivideOperation).accept(10,5);

		}
	public static void main(String[] args) {
		//ex1IteratingMap();
		//ex2CompareTwoAccNumber();
		//ex3AndThenOperation();
		ex4AndThenOperation();
	}
}

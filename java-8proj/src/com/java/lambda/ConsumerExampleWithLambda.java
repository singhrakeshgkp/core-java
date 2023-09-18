package com.java.lambda;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExampleWithLambda {

	public static void ex1ListIteration() {
		List<String> strList = List.of("rakesh","suresh");
		strList.forEach(t->System.out.println(t));
	}
	
	public static void ex2AndThen() {
		Consumer<String> consumerObj1 = t->{
			String str = t.toUpperCase()+"->";
			System.out.println(str);
			};
			
			consumerObj1.andThen(consumerObj1).accept("hello");;
	}
	public static void main(String[] args) {
		ex2AndThen();
	}
}

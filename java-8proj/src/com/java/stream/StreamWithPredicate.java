package com.java.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamWithPredicate {

	/*Predicate with filter*/
	public static void filter() {
		List<String> strList = List.of("java","java spring","java with cassandra","hadoop");
		List<String> javaTechList =strList.stream().filter(t->t.contains("java")).collect(Collectors.toList());
		javaTechList.forEach(tech->System.out.println(tech));
	}
	
	//Predicate.and -> It represent multiple filter
	public static void multiPleFilter() {
		List<Integer> ageList = List.of(12,18,29,0,35,60,77,34);
		//enrolment eligibility -> age should be between 25 and 35
		List<Integer> eligibleAgeList = ageList.stream().filter(x-> x >=25 && x<=35).collect(Collectors.toList());
		eligibleAgeList.forEach(age-> System.out.println(age));
	}
	
   //Predicate.Or -> Represent filter with logical or
	public static void predicateWithOr() {
		
		List<String> nameList = List.of("ranvijay singh","rakesh singh","rohan kumar","ranjan kumar");
	  List<String> qualifiedNameList = nameList.stream().filter(name-> name.startsWith("ra") || name.endsWith("singh")).collect(Collectors.toList());
	  qualifiedNameList.forEach(name->System.out.println(name));
	}
	
   //Predicate.negate-> repersent logical not operation
   public static void predicateWithNegate() {
	  Predicate<String> predicateStr = name->name.startsWith("ra");
	  List<String> nameList = List.of("ranvijay singh","rakesh singh","rohan kumar","ranjan kumar");
	  List<String> qualifiedNameList = nameList.stream().filter(predicateStr.negate()).collect(Collectors.toList());
	  qualifiedNameList.forEach(name->System.out.println(name));
	}
	
   public static void predicateWithTestFun() {
		  Predicate<String> predicate = name->name.startsWith("ra");
		  List<String> nameList = List.of("ranvijay singh","rakesh singh","rohan kumar","ranjan kumar");
		  List<String> qualifiedNameList = nameList.stream().filter(predicate::test).collect(Collectors.toList());
		  qualifiedNameList.forEach(name->System.out.println(name));
		}

	public static void main(String[] args) {
		//filter();
		//multiPleFilter();
		//predicateWithOr();
		//predicateWithNegate();
		predicateWithTestFun();
	}
}

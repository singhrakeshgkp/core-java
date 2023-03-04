package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamVsParallelStreamEx11 {

	/*
	 * Continue from point 15 discussed in code{StreamVsParallelStreamEx10} class 
	 * Note-> Parallel doesn't always mean fast
	 *     -> how to decide to make parallel
	 *     -> when parallel makes no sense
	 * 16. Run with Sequential stream -> output-> Kritika, it evaluates till third index
	 * 17. Run with parallel stream -> output -> Kritika, it evaluates all the elements
	 *     to check if it evaluates all the elements or not we can add syso in SVSPEx11Employee class
	 * 18. But if we say find Any with Seq stream-> Output->Kritika, it evaluates until 3rd ele
	 * 19. FindAny with Parallel Stream -> output -> unpredictable
	 * 
	 * Note:- find()-> maintain the order by nature
	 */
	public static void main(String[] args) throws InterruptedException {

		List<SVSPEx11Employee> empList = Arrays.asList(
				new SVSPEx11Employee("rajesh", Gender.MALE, 31),
				new SVSPEx11Employee("Mayank", Gender.MALE, 25),
				new SVSPEx11Employee("Kritika", Gender.FEMALE, 29),
				new SVSPEx11Employee("Dhirendra", Gender.MALE, 35),
				new SVSPEx11Employee("Mayanti", Gender.FEMALE, 29),
				new SVSPEx11Employee("Kalpana", Gender.FEMALE, 29)
				);
		
		Optional<String> name = empList.stream()
			   .filter(emp->emp.getAge() ==29)
			   .filter(emp->emp.getGender() == Gender.FEMALE)
			   .map(emp->emp.getEmpName())
			   .findAny();
		System.out.println("results :- "+name.get());
			   
	}
}

class SVSPEx11Employee{
	private String empName;
	private Gender gender;
	private int age;
	
	
	
	public SVSPEx11Employee(String empName, Gender gender, int age) {
		super();
		this.empName = empName;
		this.gender = gender;
		this.age = age;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		System.out.println("name :- "+ this.empName+"  age "+this.age );
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

enum Gender{
	MALE, FEMALE
}

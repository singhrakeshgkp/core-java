package com.java.methodandreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceExample1 {

	
	
	public static void main(String[] args) {
		
		Employee[]empArr = {new Employee("Rakesh", 29),
							new Employee("udit", 23),
						    new Employee("Sandeep", 33)}; 
			Arrays.sort(empArr, Employee::compareByAge);
		Arrays.stream(empArr).forEach(emp->System.out.println(emp.getAge()));
	}
}


class Employee {
	
	private String name;
	private Integer age;
	
	public Employee(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public static int compareByAge(Employee e1, Employee e2) {
		return e1.getAge().compareTo(e2.age);
	}
	
	
	
}
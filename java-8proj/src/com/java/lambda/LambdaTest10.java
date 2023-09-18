package com.java.lambda;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LambdaTest10 {
	
/* 
 * Collectors
 *-> Grouping
 *Problem1 -> Given a list of employee, create a map where their name is key and 
 *           value is all the people with that name
 *Solution -> groupingByEx()1
 *
 *Problem2 -> Given a list of employee, create a map where their name is key and 
 *            value is all the ages of people with that name
 *Solution -> groupingByEx2()
 *           
 * */
	
    	
        
	
       public static List<EmployeeLambdaEx10> getEmpList(){
	   List<EmployeeLambdaEx10> empList = Arrays.asList(
		   new EmployeeLambdaEx10("john", 22, GenderLambdaEx10.MALE),
		   new EmployeeLambdaEx10("max", 23, GenderLambdaEx10.MALE),
		   new EmployeeLambdaEx10("john", 25, GenderLambdaEx10.MALE),
		   new EmployeeLambdaEx10("Ariana", 22, GenderLambdaEx10.FEMALE),
		   new EmployeeLambdaEx10("Ariana", 26, GenderLambdaEx10.FEMALE)
		   
		   );
	   
	   return empList;
	   
       }
        public static void groupingByEx1() {
            
            System.out.println("Group By map Map Ex1 "+
            getEmpList().stream()
            		.collect(groupingBy(EmployeeLambdaEx10::getName)));
        }
        
        public static void groupingByEx2() {
            
            System.out.println("Group By map Map Ex2"+
            getEmpList().stream()
            		.collect(groupingBy(EmployeeLambdaEx10::getName,mapping(EmployeeLambdaEx10::getAge, toList()))));
        }
	public static void main(String[] args) { 		

	    groupingByEx1();
	    groupingByEx2();
	    
	    
	}
}

class EmployeeLambdaEx10{
    private String name;
    private int age;
    private GenderLambdaEx10 gender;
    
    
    public EmployeeLambdaEx10(String name, int age, GenderLambdaEx10 gender) {
	super();
	this.name = name;
	this.age = age;
	this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public GenderLambdaEx10 getGender() {
        return gender;
    }
    public void setGender(GenderLambdaEx10 gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
	return " [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
    
    
    
}

enum GenderLambdaEx10{
    MALE,FEMALE
}

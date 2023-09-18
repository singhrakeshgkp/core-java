package com.java.lambda;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LambdaTest9 {
	
/* 
 * Collectors
 * 1. to set
 * 2. to map
 * */
	
    	
        
	/*1. set*/
        
        public static void toSetEx() {
            List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10);
            Set<Integer> doubleOfEvenNums = new HashSet<>();
		 System.out.println("to set ");
	 doubleOfEvenNums= numbers.stream()
		        .filter(e->e%2==0)
		        .map(e->e*2)
		        .collect(toSet());
	 
	 System.out.println(doubleOfEvenNums);
	 		
        }
        
       public static List<EmployeeLambdaEx9> getEmpList(){
	   List<EmployeeLambdaEx9> empList = Arrays.asList(
		   new EmployeeLambdaEx9("john", 22, GenderLambdaEx9.MALE),
		   new EmployeeLambdaEx9("max", 23, GenderLambdaEx9.MALE),
		   new EmployeeLambdaEx9("john", 25, GenderLambdaEx9.MALE),
		   new EmployeeLambdaEx9("Ariana", 22, GenderLambdaEx9.FEMALE),
		   new EmployeeLambdaEx9("Ariana", 26, GenderLambdaEx9.FEMALE)
		   
		   );
	   
	   return empList;
	   
       }
        public static void toMapEx() {
            
            System.out.println("to Map"+
            getEmpList().stream()
            		.collect(toMap(emp->emp.getName()+emp.getAge(), emp->emp)));
        }
	public static void main(String[] args) { 		
	    toSetEx();
	    toMapEx();	    
	    
	    
	    
	}
}

class EmployeeLambdaEx9{
    private String name;
    private int age;
    private GenderLambdaEx9 gender;
    
    
    public EmployeeLambdaEx9(String name, int age, GenderLambdaEx9 gender) {
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
    public GenderLambdaEx9 getGender() {
        return gender;
    }
    public void setGender(GenderLambdaEx9 gender) {
        this.gender = gender;
    }
    
    
}

enum GenderLambdaEx9{
    MALE,FEMALE
}

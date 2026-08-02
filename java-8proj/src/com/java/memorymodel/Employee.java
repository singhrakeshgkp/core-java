package com.java.memorymodel;

import java.awt.Label;

public class Employee {

  /* static field */
  private static int employeeCount = 0;
  private static final String COMPANY =   "TechCorp";

  /* static block */

  static {
    System.out.println("Static block : class loaded, count = " + employeeCount );
  }

  /* Instance field */

  private String name;
  private int age;
  private double [] ratings;

  /* Constructor */
  public Employee (String name, int age){
    this.name = name;
    this.age = age;
    this.ratings = new double[]{4.5,4.8};
    employeeCount++;
  }

  /* Instance method */
  public String getSummary(){
    String lable = "Employee";  // local var
    return lable + ": " + name + ", age " + age;
  }


  public static int getCount(){
    int result = employeeCount; // local var
    return result;
  }

  /* Main */

  public static void main(String[] args) {
    Employee emp1 = new Employee("rakesh",32);
    Employee emp2 = new Employee("suresh",22);
    System.out.println(emp1.getSummary());
    System.out.println("Total : " + Employee.getCount());
  }
}

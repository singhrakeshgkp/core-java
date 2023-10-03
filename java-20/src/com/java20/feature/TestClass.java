package com.java20.feature;

import java.util.List;

public class TestClass {

  public static void main(String[] args) {
    List<Customer> customers = List.of(new Customer("rakesh"),new Customer("Suresh"));
    customers.parallelStream().forEach(cus->cus.setName("abcd"));
    customers.forEach(cus-> System.out.println(cus.getName()));
  }
}

class Customer {

  public Customer(String name){
    this.name = name;
  }
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

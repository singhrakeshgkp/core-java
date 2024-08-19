package com.java20.feature;

public class TestClassExample {

  /*Todays
  1.Task Java 8 Complete feature
  2. Java 8 to java 17 complete feature
  3. reading books.
  * */
  public static String switchEx(Object obj) {
    return switch (obj) {
      case Integer i when i > 20 -> "got integer greater than 20";
      case Integer i -> "got integer";
      case String str -> "got String";
      case Long l -> {
        yield "got long";
      }
      default -> "default value";
    };

  }

  public static void main(String[] args) {


  }
}

class Employee {

  private Address empAddress;

  public Address getEmpAddress() {
    return empAddress;
  }

  public void setEmpAddress(Address empAddress) {
    this.empAddress = empAddress;
  }

  @Override
  public String toString() {
    return "Employee{" + "address=" + empAddress + '}';
  }
}

class Address {

  private String city;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Address{" + "city='" + city + '\'' + '}';
  }
}
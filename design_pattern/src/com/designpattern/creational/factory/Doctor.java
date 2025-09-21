package com.designpattern.creational.factory;

public class Doctor implements  Profession{

  @Override
  public void msg() {
    System.out.println("Doctor");
  }
}

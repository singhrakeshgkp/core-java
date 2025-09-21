package com.designpattern.creational.factory;

public class Engineer implements  Profession{

  @Override
  public void msg() {
    System.out.println("Engineer");
  }
}

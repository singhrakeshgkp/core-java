package com.designpattern.creational.abstractfactory;

public class SquareWithBoldBorder implements  Shape{

  @Override
  public void draw() {
    System.out.println("Drawing Square with Bold Border");
  }
}

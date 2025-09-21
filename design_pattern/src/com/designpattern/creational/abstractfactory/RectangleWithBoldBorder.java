package com.designpattern.creational.abstractfactory;

public class RectangleWithBoldBorder implements  Shape {

  @Override
  public void draw() {
    System.out.println("Drawing Bold Rectangle shape");
  }
}

package com.designpattern.creational.abstractfactory;

public class ShapeFactoryBuilder {
  public static AbstractShapeFactory getFactory(String factoryType){
    return factoryType != null && factoryType.contains("Bold")
        ? new BoldBorderShapeFactory()
        : new ShapeFactory();
  }
}

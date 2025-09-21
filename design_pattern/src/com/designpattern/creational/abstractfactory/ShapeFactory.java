package com.designpattern.creational.abstractfactory;

public class ShapeFactory extends AbstractShapeFactory {

  @Override
  Shape getShape(String shapeType) {
    return switch(shapeType){
      case "Rectangle" -> new Rectangle();
      case "Square" -> new Square();
      default -> throw new IllegalArgumentException("not a valid shape type");
    };
  }
}

package com.designpattern.creational.abstractfactory;

public class BoldBorderShapeFactory extends AbstractShapeFactory {

  @Override
  Shape getShape(String shapeType) {
    return switch(shapeType){
      case "RectangleWithBoldBorder" -> new RectangleWithBoldBorder();
      case "SquareWithBoldBorder" -> new SquareWithBoldBorder();
      default -> throw  new IllegalArgumentException("Not a valid shape type");
    };
  }
}

package com.designpattern.creational.abstractfactory;


public class MainClassAbstractFactory {
  public static void main(String[] args){
   AbstractShapeFactory boldShapeFactory = ShapeFactoryBuilder.getFactory("Bold");
   Shape squareWithBoldBorder = boldShapeFactory.getShape("SquareWithBoldBorder");
   Shape rectangleWithBoldBorder = boldShapeFactory.getShape("RectangleWithBoldBorder");
   squareWithBoldBorder.draw();
   rectangleWithBoldBorder.draw();

   AbstractShapeFactory shapeFactory = ShapeFactoryBuilder.getFactory(null);
   Shape rectangle = shapeFactory.getShape("Rectangle");
   Shape square = shapeFactory.getShape("Square");
   rectangle.draw();
   square.draw();
  }
}

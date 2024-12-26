# Factory Design Pattern

```
Main -----> FactoryClass---->Profession--->(Doctor, Layer, Engineer) implements Profession
 
```
<p>
Define an interface for creating an object, but let subclass decide which class to instantiate. Factory method lets a class defer instantiation to subclasses. This technique also known as virtual constructor.
  
</p>

### Advantages
- Remove the object creation/instantiation logic from client code that makes code more robust and less coupled.
- Promote code for interface rather than implementation class.
- Provide abstraction between implementation and client class.
- example given in ```MainClassFactoryPattern.java``` class

### Examples from JDK
- Many classess such as Calendar.getInstance, NumberFormat, ResourceBoundle use factory method design
- JaxBContext.createMarshaller, class.forName, charset.forname ..etc

# Abstract Factory Design Pattern

```
Main-->AbstractShapeFactory-->ShapeFactoryBuilder( returns either of one ShapeFactory, BoldBorderShapeFactory)-->ShapeFactory/BoldBorderShapeFactory--> returns (Rectangle, Square/ RectangleWithBoldBorder, SquareWithBoldBorder)
```
<p>
  Provide an interface for creating families of related or dependent objects without
specifying their concrete classes.
</p>

- For java impl refer ```AbstractFactoryPatternExample.java``` class 
- <b>Use Case</b>
  - System should be independent o f how its products are created, composed,and represented.
  - When your system requires multiple families of related products and you want to ensure compatibility between them.
  - When you aim to maintain consistency across different product families, ensuring a uniform interface for the products.
  

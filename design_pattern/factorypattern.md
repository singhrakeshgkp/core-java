# Factory Design Pattern

```
 Main -----> FactoryClass---->Profession--->(GovtOfficer,Doctor, Layer, Engineer)
```
<p>
Define an interface for creating an object, but let subclass decide which class to instantiate. Factory method lets a class defer instantiation to subclasses. This technique also known as virtual constructor.
  
</p>

### Advantages
- Remove the object creation/instantiation logic from client code that makes code more robust and less coupled.
- Promote code for interface rather than implementation class.
- Provide abstraction between implementation and client class.
- example given in ```FactoryPatternExample1.java``` class

### Examples from JDK
- Many classess such as Calendar.getInstance, NumberFormat, ResourceBoundle use factory method design
- JaxBContext.createMarshaller, class.forName, charset.forname ..etc

# Abstracto Factory Design Pattern
<p>
  Provide an interface for creating families of related or dependent objects without
specifying their concrete classes.
</p>

- For java impl refer ```AbstractFactoryPatternExample.java``` class 
- <b>Use Case</b>
  - system should be independent o f how its products are created, composed,and represented.
  - a system should be configured with one of multiple families of products.
  

# Lambda
### Disadvantage of Anonymous inner classess
- The more Anonymous classs class you will create, the more anonymous class you will have in the disk that results in you will end up with big jar files.
- Loading these jar files gonna take more time.
- Consume more space in memory
- ```LambdaTest1.java``` -> complile the class, you will observe multiple class file for the anonymous .class will be created. If we do the same thing with lambda there will be only single .class file
### External vs Internal Iterators
- External Iterator
  - Programmer have more control on it, you have to initialize and set the boundry of loop
- Internal iterator 
  - can be iterated in clear and compact way.

### Method Reference
   - Parameter as an argument ```LambdaTest2.java```
     ```
     numbers.forEach(System.out::println);
     ```
   - parameter as an argument to a static method ```LambdaTest2.java```
   - parameter as a target ```LambdaTest3.java```
   - two parameters as an arguments ```LambdaTest4.java```
     - order should be same, if its not you can not apply method references. As shown in the following example ```total, e``` order is not same so mehtod refercen can not be applied.
      ```
        numbers.stream()
	      .reduce(0,(total,e)->Integer.sum(e,total)));// it should be total,e not e, total
      ```
   - two parameters one as target the other one as argument ```LambdaTest6.java```
     
 ### Limitations of Method Reference
 - You can not use them if you are doing data manupulation
 - you can not use them if there is conflict between instance method and static method

### Function Composition
- composing series of function or pipiline is called function compositon ```LambdaTest6.java```
# Functional Interface
- Consumer
  - Represents an operation that accepts a single input and returns no result
- BiConsumer 
  - Represent as operation that accepts two input arguments and returns no result
  - Can be used while iterating hash map, can be used to compare two objects
- Predicate
  - Represents a predicate (boolean-valued function) of one argument
  - 
- 
  


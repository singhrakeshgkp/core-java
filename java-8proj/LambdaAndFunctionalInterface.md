# Functional programming
### Reference https://www.youtube.com/watch?v=15X0qFtBqiQ&t=69s  [Venkat]

```
 whats wrong with mutable state?
   Error Prone
   Hard to reason (hard to read and tell the reason for output)
   Hard to make concurrent
Whats functional programming is?
  its means assignment less programming 
  immutable state
  functions as first class citizen
  We can perform following things in functional programming
        Imperative                               functional(higher order function)
	can pass obj to function		 can pass function to function
	can create obj within function		 can create function within function
	can return obj from function		 can return function from function
 Function with no side effects(have to be pure)
   1. pure function does not change anything
   2. Pure function does not depend anything that change
	
```
### Lambda VS. Closures
- ```LambdaVSClosures1```

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
   - two parameters one as target the other one as argument ```LambdaTest5.java```
     
 ### Limitations of Method Reference
 - You can not use them if you are doing data manupulation
 - you can not use them if there is conflict between instance method and static method

### Function Composition
- composing series of function or pipiline is called function compositon ```LambdaTest6.java```
# Functional Interface

1. Consumer/BiConsumer----> accept one/two arguments and return nothing, has "void accept(T t)" method
2. Supplier----> accept zero argument and return given type, has "T get();" method
3. Predicate/BiPredicate------> takes one/two argument and return boolean value, has "boolean test(T t);" method
4. Function/BiFunction-------> takes one argument and return supplied type. has " R apply(T t);" method
5. UnaryOperator-----> uses where operand and return type is of same type. Specilized form of Function interface.

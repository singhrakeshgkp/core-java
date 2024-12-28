# Design Pattern
- [Design Patterns](#design-patterns)
   - [Creational](#creational)
   - [Structural](#structural)
   - [Behavioural](#behavioural)
   - 

# Design Pattern By Venkat Subramaniam

https://www.youtube.com/watch?v=llGgO74uXMI  <br/>
### Some important design concepts 1

<hr/>

##### What is good design?,

- Almost impossible to get it right the first time. It takes several iteration. Some people believe that software is never written it is re-written.
- To create a better design first step is to let it go of the ego.
- Be unemotional .
- There are two kinds of people that are dangerous to work
  1. who can't follow instructions.
  2. who can only follow instructions.

##### Keep it Simple
- what is simplicity ?
  - Simple keeps you focussed
  - Simple solves only real problem we know about
  - Simple fails less
  - Simple is easier to understand.
  - Simple is not necessarily familiar. So as a develoer you have to go beyond familiar to explore simplicity.
 
#### Complexity 
- Complexity makes code difficult to change.A good design is the one that hides inherent complexity and eliminate accidental complexity.
- Inherent and Accidental Complexity
  - inherent -> Complexity from problem domain,nothing one can do about it.
  - accidental -> This kind of complexity comes form the solution that we are using to solve a problem.
### Think YAGNIy(you aren't gonna need it yet)
 - Postpone the things until they are really really needed.
 - Before implementing any thing consider following points
  ```
  when should i implement something?
  how much do you know?
  Cost of implementing?
  Now                          Later
  $N          >               $L - Postpone it
  $N          =               $L- Postpone it
  $N          <               $L- how probbable ? high- do it now if low then postpone.
  ```
##### Cohesion 
- Cohesion is where a piece of code narrow focused and does only one thing well
- Cohesion code is a code that is not taking several responsibility. such as dao handling code should be seperated with xml processing... etc
##### Coupling
 - Coupling is degree of connectivity among things
 - Coupling is essesntially what you depend on
 - worst form of coupling is inheritance, it increases the coupling quite a bit.
 - try to see if you can remove coupling
 - can't remove all the dependencies.
 - get rid of it
 - make it loose instead of tight
    - loose -> depending on interface is loose coupling
    - tight -> depending on class in tight coupling
 - A good design should have high cohesion and low coupling
##### Dealing with coupling
 - Depend on interface rather than class
##### Keep it Dry(don't repeat yourself)
- don't duplicate  cod and effort.
- Every piece of knowledge in a system should have a single unambiguous authorative representation.
- It reduces the cost of development.
#### Focus on single responsibility 
- Long Method -> Long methods are bad, as it says low cohesion and high coupling which is not good. some of the reason is given below why long methods are bad.
  - hard to test
  - hard to read
  - hard to remember
  - obscured business rules
  - hard to reuse
  - leads to duplication
  - many reasons to change
  - hard to debug.......
- A function is small enough if you can see entire function in a window OR 
- SLAP(single level of Abstraction Principle) 
  - dont comment what, instead comment why (while using comment in code)
- Use compose method pattern
##### Don't violate open close principle (OpenCloseExample1.java)
- Software module should be open for extenstion but closed for modification. Abstraction and Polymorphism are the key to make this happen.
- two make and enhacement you have two options
  ```
  Java classess 
   OpenCloseExample1.java, OpenCloseExample2.java OpenCloseExample3.java, OpenCloseExample4.java OpenCloseExample5.java
  ```
  1. change existin gcode.
  2. add a small new module of code.(recommended option)
##### Liskov's Substution principle
- Inheritance should be used only for substitutability.
- If an object of B should be used anywhere an object of A is used then use inheritance.
- If an object of B should be use an object of A, then use composition/delegation.
- Inheritance demands more from developer than composition/delegation does.
 ```
  Services of the derived class should require no more and promise no less than the corresponding services of the base class.
  now the question is why?
  Ans is, The user of base class should be able to use an instance of derived class without knowing the difference.
  
  Examples.
  Good
  public vs protected in base vs derived class (its implemented on java framework label, you can not be more restrictive in derived class but u can be generous)->LiskovSubsExample1.java
  derived function can't throw any new checked exceptions not thrown by base(unless new exception extend the old one thrown by base class)-> LiskovSubsExample2.java
  collection of derived does not extend form collection of base. see LiskovSubsExample3.java
  Bad
  Stack
 ```
- Use composition or delegation instead of inheritance unless you want substitutabiliy. ```LiskovSubsExample4.java```

##### Decouple using the dependency inversion principle
- A class should not depends on another class, they both have to depends on abstraction (interface), prefer to use lambda expression only unless there is no option.

##### Keep Interface cohesive with interface segregation principle
- Interface should be cohesive and narrow focused

### Some important design concept 2

<hr/>

https://www.youtube.com/watch?v=yTuwi--LFsM&t=54s
- Optional and AntiPattern->Null is smell, Avoid Null as much as possible, A good design read like story and not like puzzle,it make the code obvious , Effective java says:- do not return null, instead return an empty collection. Benfit of not returning null is listed below.
 ```
  Benfits
  --------------------------------------
  you can iterate over empty collection without null check
  But what if we have single value-> in the past we returned null, but now we should really return an optional<T>
  
  where to use optional?
  --------------------------------
    1. if a method return single value not collection
    2. don't use optional if function is always gonna return some value
    3. don't use optional as parameter to method, if needed use overloading instead
    4. There is a little reason to use optional<T> as a field
  
 ```
- Internal Iterator VS External Iterator ```IteratorPattern1.java```-> A functional pipeline offers internal iterator, it is less complex, easy to modify, easy to understand but....it is very important that we make the functional pipeline pure. Avoid shared mutable variables

- Lightweight Strategy Pattern -> Lambda are lightweight strategy ```LightweightStrategyPattern.java```
- Factory Vs Abstract Factory ```FactoryPattern1.java```
  - Factory Method-> A class or interface relies on a derived class to provide the implementation whereas base class provide the common implementation. 
    - It uses Inheritance as design tool
    - Interfaces and default method nicely fit in to Factory method pattern.
  
  - Abstract Factory->  
- Lazyness Using Lambda Expression ```LazyEagerEvaluationEx1.java```
- Decorator using Lambda expression
  - Before understanding Decorator with Lambda first have to understand Function composition ```FunctionCompositionEx1.java```
  - ```DecoratorWithLambdaPattern1.java```
- Cascade Method pattern ```CascadeMethodPattern.java``` (its very much similar to builder but its not builder)
- Creating fluent interfaces ```FluentInterfaceEx1.java```
- Execute around method pattern ```ExecuteAroundMethodPattern1.java,  ExecuteAroundMethodPattern2.java``` Deals with object allocation and de-allocation from users of an object   -> Very useful pattern
- Creating a closed hierarchy with sealed ```SealedInterfaceExample1.java```

# Design Patterns
- Is well tested solution to problems that we faced day to day software development.

## Creational

- Singleton for more details click [here](/design_pattern/singleton.md)
- Factory and Abstract Factory for more details click [here](/design_pattern/factorypattern.md)
- Builder for more details click [here](/design_pattern/builder.md)
- Prototype
- 
## Structural

- Adapter pattern  -->done
- Bridge Pattern
- Composite Patter
- Decorator Pattern -->done
- Proxy Pattern
- Façade pattern  --> done
- Flyweight Pattern


## Behavioural

- Template method
- Mediator Pattern
- Chain of responsibility pattern
- Observer Pattern
- Command Pattern
- Strategy Pattern
- Visitor Patter
- State Pattern
- Interpreter Pattern and so on
- .....etc

<hr/>


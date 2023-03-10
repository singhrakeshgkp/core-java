# Design Pattern By Venkat Subramaniam


### Some important design concepts 1
- Keep it Simple
  - Simple keeps you focussed
  - Simple solves only real problem we know about
  - Simple fails less
  - Simple is easier to understand.
- complexity
  - inherent -> Complexity from problem domain,nothing one can do about it.
  - accidental -> This kind of complexity comes form the solution that we are using to solve a problem.
- Cohesion 
  - Cohesion is where a piece of code narrow, focused and dones only one thing well
  - Cohesion code is a code that is not taking several responsibility. such as dao handling code should be seperated with xml processing... etc
- Coupling
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
- Dealing with coupling
  - Depend on interface rather than class
- Keep it Dry(don't repeat yourself) -> don't duplicate  cod and effort.
- Focus on single responsibility
- Long Method -> Long methods are bad, as it says low cohesion and high coupling which is not good. some of the reason is given below why long methods are bad.
  - hard to test
  - hard to read
  - hard to remember
  - obscured business rules
  - hard to reuse
  - leads to duplication
  - many reasons to change
  - hard to debug.......
- Don't violate open close principle ->

### Some important design concept 2
https://www.youtube.com/watch?v=yTuwi--LFsM&t=54s
- fdsf
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
# Creational

- Singleton for more details click [here](/design_pattern/singleton.md)
- Factory and Abstract Factory for more details click [here](/design_pattern/factorypattern.md)
- Builder for more details click [here](/design_pattern/builder.md)
- Prototype
# Structural

- Adapter pattern
- Bridge Pattern
- Composite Patter
- Decorator Pattern
- Proxy Pattern
- Façade pattern
- Flyweight Pattern


# Behavioural

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


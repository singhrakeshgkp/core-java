# Creational

- Singleton
- Factory
- Abstract Factory
- Builder
- Prototype

<details> <summary><b>Singleton</b></summary>
<p>
  
 - Ensures that a class can only have one object
 - How to create singleton class
   - <b>Approach 1 </b>SingletonExample1-  Eager Initialization
     - Instance of singleton class is created at the time of class loading
     - Drawback of eager initialization is that, instance gets created even though client is not using it, it aslo do not provide options for exception handling.
     - Create private constructor
     - Create a private attribute of class type and initialize it
     - Create an static method that will allow client to access the object.
   - <b>Approach 2 </b>SingletonExample2- Static Block Initialization
     - It is similar to eager initialization the only difference is that the instance of the class created in static block that provides the opitons for exception handling.
   - <b>Approach 3</b> SingletonExample3- Lazy Initialization
     - Create instace in a global access method.
     - Drawback - When it comes to multithreaded application, it can cause issue when multiple threads are in the ```if``` block at the same time.- It destroy the singleton pattern/principle and both the thread will get different instance/object.
  
   - <b>Approach 4</b> SingletonExample4- ThreadSafe
     - Simplest way to create thread safe singleton class is to make the global access method ```synchronized```
     - The drawback of this technique is, it reduce the performance because of the cost associated with the synchronized method. To avoid this double-checked locking principle is used refer ```SingletonExample5.java``` class.
   - <b>Approach 5</b> SingletonExample5- Bill Pugh Method
     - Prior to java 5, java memory model had a lot of issues, approaches above we used to fail in certain situation where multiple thread try to get the instace of the isngleton class simultaneously.
    - Bill Paugh introduced a new approach to create singleton class using static inner class.
    - Inner static class gets loaded in the memory only when someone call getInstance method.
- Where to use singleton patter? [Ans](https://stackoverflow.com/questions/3192095/where-exactly-the-singleton-pattern-is-used-in-real-application)
 - Example 
   - java api -> java.lang.Runtime#getRuntime()
  
</p>
</details>

# Structural

- Adapter pattern
- Bridge Pattern
- Composite Pattern
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


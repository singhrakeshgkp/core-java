
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
   - <b>Approach 5</b> SingletonExample6- Using Enum
     - Reflection can be used to destroy the singleton patterns discussed in approach 1 to 5, to overcome this, we can use the enum to implement singleton pattern
     - In case of enum java ensures that any enum value will be initiated only once in java program.
     - Drawback of this approach is it does not support lazy initialization.
- Where to use singleton patter? [Ans](https://stackoverflow.com/questions/3192095/where-exactly-the-singleton-pattern-is-used-in-real-application)
 
 ### Singleton with Serialization
 - Serialization can destroy the singleton pattern, to get get rid of it we can provide implementation of ```readResolve``` method.
 - Refer SingletonExample7(we destroy the singleton pattern) + SingletonExample8(provided impl for readResolveMethod)
 - The readResolve method is called when ObjectInputStream has read an object from the stream and is preparing to return it to the caller. ObjectInputStream checks whether the class of the object defines the readResolve method. If the method is defined, the readResolve method is called to allow the object in the stream to designate the object to be returned. The object returned should be of a type that is compatible with all uses. If it is not compatible, a ClassCastException will be thrown when the type mismatch is discovered.
 
 ### Example from Java api 
   - java api -> java.lang.Runtime#getRuntime()

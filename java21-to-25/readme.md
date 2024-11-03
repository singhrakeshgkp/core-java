# Java 21 to java 25

- [References](#references)
- [Virtual Thread and continuation](#virtual-thread-and-continuation)
   - [Platform threads](#platform-threads)
   - [Virtual Threads](#virtual-threads)
   - [Virtual Thread Scheduler](#Virtual-Thread-Scheduler)
   - [Continuation in java](#Continuation-in-java)
     - [Uses of continuation](#uses-of-continuation)
     - [Generator](#generator)


### References

### Virtual Thread and Continuation
##### Platform threads
- Platform threads is thin wrapper over OS thread, VM needs to create a platform thread, it requests OS to create a new OS thread. Once OS thread gets created JVM create a platform thread.
- Platform threads and OS threads has 1 to 1 mapping
- Creating platform threads is and expensive operation/intensive tak so we put them in pool

##### Virtual Threads
- Lightweight user thread(as it requires very less memory)
- its highly scalable
- No need to pool
- Mostly used in IO intensive operation
- A virtual threads can not do anything on its own, it requires platform thread to do/execute something
  
##### Virtual Thread Scheduler
- A virtual thread scheduler mounts a virtual thread on a platform/carrier thread when virtual thread requires platform thread. And it unmounts virtual threads when virtual thread does not require platform thread.
  
#### Continuation in java
- Use VM ```--enable-preview --add-exports java.base/jdk.internal.vm=ALL-UNNAMED``` while compiling or running your application as continuation is not designed for developer use.
- Continuation can be viewed as a representation of current state of program
- Allow to pause execution of a program and run it later.

##### Uses of Continuation
- Virtual/Green Threads
- Coroutines
- Exception handling
- Generators
###### Note- Continuation api in java is not suppossed to used by application developer. Java uses it internally to impement virtual threads
##### Generator
- A Generator allows us to write a function that 'yields' values, these values are lazily retrieved. They can be iterated over a loop.


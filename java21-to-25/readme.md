# Java 21 to java 25

- [References](#references)
- [Virtual Thread](#virtual-thread)
   - [Continuation in java](#Continuation-in-java)


### References
- https://www.youtube.com/watch?v=pwLtYvRK334&t=1917s
- 
### Virtual Thread
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
- Continuation can be viewed as a representation of current state of program
###### Note- Continuation api in java is not suppossed to used by application developer. Java uses it internally to impement virtual threads




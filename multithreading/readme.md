# Table of contents
- [Multithreading](#multithreading)
  - [Memory model](#memory-model)
     - [Field Visibility](#field-visibility)
     - [Volatile vs Atomic Variables](#volatile-vs-atomic-variables)
  - [ThreadLifecycle](#threadlifecycle)
  - [Thread Synchronization](#thread-synchronization)
     - [Limitation of traditional synchronization](#limitation-of-traditional-synchronization)
  - [java util concurrent lock](#java-util-concurrent-lock)
  - [Thread Group](#thread-group)
  - [Executor Service](#executor-service)
  - [ForkJoinPool](#forkjoinpool)
  - [Blocking vs Synchronous Queue](#blocking-vs-synchronous-queue)
    - [Blocking Queue](#blocking-queue)
    - [Synchronous Queue](#synchronous-queue)
  - [Thread Local](#thread-local)
  - [Race Condition](#race-condition)
  - [Dead Lock](#dead-lock)
  - [Advanced Topics](#advanced-topics)
  - [Q & A](q-&-a)


# Multithreading
## Memory Model
### Field Visibility
- refer [Diagrams](/multithreading/memory-model.png) diagram2
- Lets say we have two core cpu and two thread T1, and T2 running on core1 and core2. Lets say we have one variable x, T1 thread seting x=1 using some memthod lets say write and T2 is trying to read that value.
- Here T2 Thread will not get value what T1 has set as its available in core1 local cache, in core2 local cache its still 0
- Using ```volatile``` keyword in java we can overcome this situation, if volatile keyword is used with variable x and when x values changes to 1. It is flushed/pushed into shared cache. Now when anyother thread tries to read the value it will always get updated value
- **Happens Before ->** Lets say here x is valatile, in java there is a rule that is if any write operation happens before x=1 that also will be pushed to shared cache/main memory so value of variable a,b,c also will be visible to other threads.
  ```
  T1(a=1; b=1;c=1 x=1) T2(int p=x;q=a;r=b;s=c)
  ```
### Volatile vs Atomic Variables
- volatile solves visibility problem and Atomic variable solves synchronization problem
- ex cpu =2, threads = T1, T2 in t1 and t2 we are doing value++(two operation read and write is happening), it might be possible that T1 reads the value before T2 write, in that case what ever value T2 will update will be lost and overriden by T1.

   
## ThreadLifecycle
- There are six sates of threads, at any point of time,a thread will be any one of these six states.
1. **New** ---> When we create a thread but not started
2. **Runnable**--->when we call T.start, if thread started consuming cpu cycles then its in running state.
3. **Blockeed**---> a thread enters in block state in one of the following scenario
   -  **Synchronized method/block**---> when a thread to enter in synchronized method/block which is already being used by another thread.
   -  **ReentrantLock**---> if a thread attempts to acquire reentrantlock that is already held by another thread, it will not get the lock immediately. Instead it will go in block state.
4. **Waiting**---> Following methods can be caused a thread to enter into ```waiting``` state. In waiting state a thread release the lock and don't uses the cpu and remains inactive until they are awakened by another thread.
   - **Object#wait()**--> wait until another thread calls notify() or notifyall() method on the same object
   - **Thread#join** ---> make the calling thread(not t1.join thread) wait, until another specefied thread finishes it execution. example in main thread we have created thread t1, then we are doing t1.join() finally we are performing additional taks, here main thread will be blocked until t1 finishes its execution.
   - **LockSupport.park():**---->Thread state will transition into waiting state and remain in the waiting state until it receives an explicit signal to continue, typically through unpark() method()
   - **CyclicBarrier.await()**---> Threads waiting on cyclic barrier will be in waiting sate until the required number of thread arrived.
   - **CountDownLatch.await()**---> Threads waiting on countdownlatch enter the waiting state until the latch count reaches zero.
5. **Timed_Waiting**----> wait(long timeout), sleep(long millis),LockSupport.parkNonos(nlong anos),Thread.join(long millis)......etc
6. **Terminated**------> When thread completes its execution.

## Thread Synchronization
- **Synchronized(X.class)**----> Make sure there is exactly one thread in the block, We use class level locking to make static data member thread safe.
- **Synchronized(this)**-----> ensures one thread per instance is in the block.
## Limitation of traditional synchronization
- don't have flexibility to try for a lock without waiting
- no preference can be specified, once lock is release any waiting thread can acquire the lock
- Synchronized keyword can not be used accross the multiple method. **To overcome these limitations we can use java.util.concurrent.locks package.**

## java util concurrent lock


## Thread Group 
- We can group threads into thread gorup and perform cretain action in that group such as checking active count, setting priority on group level.For thread group example refer ```ThreadGroupEx.java``` class
## Executor Service
- There are four kind of executors, which are given below. for [Diagram](/multithreading/executors.png) click here
- 1.Fixed Thread Pool--> Lets say i have 100 taks, and Fixed thread pool of size 10. each thread will pick one taks at a time and execute it. ex T1 picks task1, after finishing it might pick task3 ... so on. Its uses blocking queue internally each thread perform two taks first fetching taks from queue and second executing the task
- 2.Cached Thread Pool-->
- 3.Scheduled Thread Pool-->
- 4.Single Threaded Executor-->
- **execute() vs submit() -->** with callable we should use executor.submit() not execute() as it submit() returns some value we should accept those value. ```Future``` is a placeholder in which value arrive. 

## ForkJoinPool
- It breaks down the big tasks in to two taks solve them independently and finally join their output. Follow Kind of divide and conquer approach.
## Blocking vs Synchronous Queue
- [Diagrams](/multithreading/blocking-and-sync-queue.png)
### Blocking Queue
- Blocking queue is a thread safe data structure in which multiple producer and consuer thread can work at the same time. For simplicity diagram depict one producer and one consumer thread
- Lets say we have one producer T1 and one consumer T2 thread, producer keep on adding element in the queue whereas consumer takes the elements from queue as shown in the diagram.
- When blocking queue is empty and consumer thread tries to consume element from the queue, since there is no element in the queue, consumer thread will into block state. As soon as thre is an item/element get available in the queue, consumer thread gets unblocked and consume the item from the queue.
- When blocking queue is full and producer thread tries to produce/add element in the queue, since there is no space in the queue, producer thread gets blocked. As soon as consumer thread consume item and slots become available, producer thread gets unblocked and it produces/pushes the item in the queue. 
### Synchronous Queue
- Synchronous queue is same as blocking queue of size one. It behave same ways as blocking queue.
- Synchronous queue is different with blocking queue in term of put operation.
- When producer thread tries to put and item in the synchronous queue, even though the queue is empty the producer thread gets blocked. This is because the producer thread will wait for the consumer thread to come and get the element. As soon as there is a consumer thread which perform the take/consume operation producer thread gets unblocked and it will put/produce the item in the queue. This process will go on....Now consumer will unblocked and consume the item if item is available.
- Perfect for hand off

## Thread Local
- Having a variable which is specific to a particular thread is called thread local.
- One possible (and common) use is when you have some object that is not thread-safe, but you want to avoid synchronizing access to that object (I'm looking at you, SimpleDateFormat). Instead, give each thread its own instance of the object.
### Use case 1
- Lets say we have one class Employee, and one method named getDOB(). In getDOB() method we are formatting date for that we have DateFormat object.
- Now assume that we have 10k employee, and we are creating 10k taks and submitting that to Executor Service,in this scenario 10K ```DateFormat``` object will be created. Unnecessary memory will be allocated here.
- To avoid unnecessary memory allocation we can define ```DateFormat``` object globally but hold on we can not use it with multiple thread as ```DateFormat``` is not thread safe so this approach is also not fit.
- what if we use synchronization with Global ```DateFormat``` object----> This will slow down the performance
- We can define ```DateFormat``` object depending on number of threads executing 10k taks, lets say 20 thread is executing 10k taks. so here we can have 20 DateFormat object for each thread this will solve above issues.

  ```
  1 object per task-->loss of memory, 2. Global Object with No locks--->No thread safe issue, if use lock it will slow down performance.

  4. Thread specific object depicted below.
  T1---------->1 object
  .....
  T20--------->20th Object
   ```

##  Advanced Topics
- [CountDownLatch](/multithreading/count-down-latch.md)
- [CyclicBarrier](/multithreading/cyclic-barrier.md)
- [Phaser](/multithreading/phaser.md)




- How to find blocked state threads? Ans -> Using thread dump analysis, there are couple of tools that can we used for this purpose
- Blocked threads vs Blocking Threads ---> Blocked threads are those threads which are currently in ```Blocked``` state, Blocking threads are threads that caused other threads to enter into ```Blocked``` sate

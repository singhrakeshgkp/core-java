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
  - [Synchronous Queue](#synchronous-queue)
  - [Race Condition](#race-condition)
  - [Dead Lock](#dead-lock)
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
- [Diagrams](/multithreading/blocking-and-synch-queue.png)
### Blocking Queue
### Synchronous Queue

## Q & A
- How to find blocked state threads? Ans -> Using thread dump analysis, there are couple of tools that can we used for this purpose
- Blocked threads vs Blocking Threads ---> Blocked threads are those threads which are currently in ```Blocked``` state, Blocking threads are threads that caused other threads to enter into ```Blocked``` sate

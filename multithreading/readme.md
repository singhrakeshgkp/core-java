# Table of contents
- [Multithreading](#multithreading)
  - [ThreadLifecycle](#threadlifecycle)
  - [Thread Synchronization](#thread-synchronization)
  - [Race Condition](#race-condition)
  - [Dead Lock](#dead-lock)
  - [Thread Group](#thread-group)
  - [Q & A](q-&-a)


# Multithreading
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

## Thread Group 
- We can group threads into thread gorup and pverfom certation action in that group such as checking active count, setting priority on group level.For thread group example refer ```ThreadGroupEx.java``` class
## Q & A
- How to find blocked state threads? Ans -> Using thread dump analysis, there are couple of tools that can we used for this purpose
- Blocked threads vs Blocking Threads ---> Blocked threads are those threads which are currently in ```Blocked``` state, Blocking threads are threads that caused other threads to enter into ```Blocked``` sate

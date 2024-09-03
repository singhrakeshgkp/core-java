# Table of contents
- [Multithreading](#multithreading)
  - [ThreadLifecycle](#threadlifecycle)

# Multithreading
## ThreadLifecycle
- There are six sates of threads, at any point of time,a thread will be any one of these six states.
1. **New** ---> When we create a thread but not started
2. **Runnable**--->when we call T.start, if thread started consuming cpu cycles then its in running state.
3. **Blockeed**---> a thread enters in block state in one of the following scenario
   -  **Synchronized method/block**---> when a thread to enter in synchronized method/block which is already being used by another thread.
   -  **ReentrantLock**---> if a thread attempts to acquire reentrantlock that is already held by another thread, it will not get the lock immediately. Instead it will go in block state.
5. **Waiting**---> Following methods can be caused a thread to enter into ```waiting``` state. In waiting state a thread release the lock and don't uses the cpu and remains inactive until they are awakened by another thread.
  - jj
  - 
7. **Timed_Waiting**---->
8. **Terminated**------>

- How to find blocked state threads? Ans -> Using thread dump analysis, there are couple of tools that can we used for this purpose
- Blocked threads vs Blocking Threads ---> Blocked threads are those threads which are currently in ```Blocked``` state, Blocking threads are threads that caused other threads to enter into ```Blocked``` sate

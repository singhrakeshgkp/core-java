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
5. **Waiting**--->
6. **Timed_Waiting**---->
7. **Terminated**------>


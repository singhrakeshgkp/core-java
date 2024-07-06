# Thread
### Multithreading Core
<details>
<summary><b>Thread LIfecycle</b></summary>
  
<p>
  
  - Can be created using runnable instance or by directly extending thread class
  - Thread Lifecycle ![thread](https://github.com/singhrakeshgkp/core-java/blob/master/Java8_Proj/threadlifecycle.jpg?raw=true)
  
</p>
</details>

<details>
<summary><b>Join, Notify, Sleep and Wait</b></summary>
  
<p>
  
  - **Join** -> Current thread to wait for the calling thread(t.join()) to finish
  - **wait and notify** 
    - ThreadWithWaitAndNotifyPubLisherConsumerExample
    - ThreadWithWaitAndNotifyOddEvenApproach1
    - ThreadWithWaitAndNotifyOddEvenApproach2
  
</p>
</details>

### Adcanced Concept
#
<details>
<summary><b>Executor Framework</b></summary>
  
<p>
  
  - Type of pools
    - FixedThreadPool
    - CachedThreadPool
    - ScheduledThreadPool
    - SingleThreadPool
</p>
</details>

 
<details>
<summary><b>CountDownLatch and Cyclic Barrier</b></summary>
  
<p>
  
  <b>CountDownLatch</b></br>
  
  - Allow One thread to wait for one or more thread before start processing.
  - This kind of functionality can be imlemented using using wait and notify but here we need to write lot of boilerplate code
  - Once count reaches to zero you can not use count down latch anymore, for such kind of scenario we have another class called cyclicBarier
</p>
  
<p>
  <b>CyclicBarrier</b></br>
  
  - It is a synchronizer that allows a set of thread to wait for each other to reach a common execution point aslo called barrier
  - dsf
</p>
  
</details>

  
  
<details>

<summary><b>Parallel and Asynchronous programming with Stream and Completable future </b></summary>
  
<p>
  
  for more details click [here](/java-8proj/parallel-programming.md) For more details refer [you tube video](https://www.youtube.com/watch?v=0hQvWIdwnw4)
</p>
</details>


<details>
<summary><b>Fork/Join Framework</b></summary>
  
<p>
  
  - createing Simple fork join Pool Program using ``` RecursiveAction ```
    - Create a java class ``` ForkJoinPoolWtihRecursiveActionExample ``` and  ``` RecursiveActionDemoTask ``` class extending ``` RecursiveAction  ``` 
    - Create a pojo class named item 
    - write the required logic
  - createing Simple fork join Pool Program using ``` RecursiveTask ```
    - Create a java class ``` ForkJoinPoolWithRTExample ``` and  ``` RecursiveTaskDemo ``` class extending ``` RecursiveTask  ``` class
    - Write the required logic
  - Running several tasks asynchronously
  - Executing throws the exception
  - Cancelling tasks
  
</p>
</details>


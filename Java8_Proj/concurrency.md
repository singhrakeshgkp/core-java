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
  
  - Executor
  - Completable Future
  - ForkJoinPool
    - Create a java class ``` ForkJoinPoolExample ``` and  ``` RecursiveActionDemo ``` class extending ``` RecursiveAction  ``` class in the same java file
    - 
  
  
</p>
</details>

<details>
  
  
<summary><b>Completable Future</b></summary>
  
<p>
  
  - CompletableFuture
  
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


# Imperative and Functional Style programming
referred https://www.youtube.com/watch?v=0hQvWIdwnw4    (Venkat Subramaniam)
- imperative style
  - Has accidental complexity.
  - Structure of sequential code is very different from the structure of concurrent code.
  - Difficult to paralelize
- Functional style
  - Has less complexity and easier to parallelize.
  - Structure of sequential code is identical to the structure of concurrent code
  - Easy to parallelize
- See ```ImpFunStyleEx1.java```

# Stream VS Parallel Stream
- ```StreamVsParallelStreamEx1.java```
- ```StreamVsParallelStreamEx2.java```
- Calling parallel and sequential both on the same pipeline ```StreamVsParallelStreamEx3.java```
  - Nature of the execution of pipline depends on the operation we are performing before terminal operaton.
  - For example following code snippet will perform sequention operation
    ```
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		numbers.stream()
			   .parallel()
			   .map(ele->process(ele))
			   .sequential()
	      .forEach(number->System.out.println(number));
    ```
- Streams Vs Reactive Streams
  - Streams
    - Sequential vs parallel
    - entire pipeline is sequential or parallel(could not be one segment parallel and another is sequential)
  - Reactive Streams
    - Sync vs Async
    - one segment could be sync and another could be async
### Observing Thread, Order of Execution and Controlling the order
- Before java 5, we were creating thread which is also a time consuming process(creating thread each time).
- So java 5 introduces Executor Service so thread can be resued.
- <b>Pool Induced DeadLock -></b> Lets say you have two thread in the pool
  - u got one small problem, you give the problem to thread1, thread1 will handle it and give u the response back
  - this time u got the problem, double in size to previous one. Break the problem and divide it between thread.
  - What if u got 4X size problem, both thread will divide the problem and start waiting to each other to solve, this is where Pool Induced Deadlock will arrive. To solve this problem java 7 introduces FJK(fork join pool) which uses Workstealing kind of algo.
- ```StreamVsParallelStreamEx3.java```
- ```StreamVsParallelStreamEx4.java```
- ```StreamVsParallelStreamEx5.java```
 
### Parallel and Filter
- ```StreamVsParallelStreamEx6.java``` This will produce the output same way as parallet with map produced(discussed in StreamVsParallelStreamEx3,4,5 )
### Parallel and reduce
- Reduce works as depicted below
  ```
  	 e1    e2   e3
  	 |     |     |
  init -->Op--->Op--->Op
  It seems here operation is happening  sequentially but it turns out this is not the really case
  ```
 - ```StreamVsParallelStreamEx7.java```

### Computation intensive vs  IO Intensive
- Computation Intensive
  - For this #(Number) of threads<=  #(number) of cores, otherewise you will end up with poor performance
- IO Intensive
  - #of threads may be greater than # of cores, but how many? Ans of this question is given below
    ```
                     	   # cores
	    #Thread <= ---------------------------------
			   1- Blocking factor
	   Where blocking factor shold be between 0 and 1 (0<=blocking factor <1)
    ```
### Default No of threads
   ```StreamVsParallelStreamEx8.java```
### Configuring number of threads jvm wide
  ```
  -Djava.util.concurrent.ForkJoinPool.common.parallelism=50
  ```
  
 ### Configuring number of threads Programatically
  ```StreamVsParallelStreamEx9.java```
  ```StreamVsParallelStreamEx10.java```
  ```StreamVsParallelStreamEx11```
  
# CompletableFuture

<p>
  
 CompletableFuture is extension of ```Future``` api, it addressed the following concerns of Future api. When two or more threads attempt to complete, completeExceptionally, or cancel completableFuture only one of them succeeds.
 for more detials check java [doc](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html) 

</p>

- There is no way to complete the future, we can only attempt to cancel the task
- The get method in ```Future``` is blocking operation
- No support for exception handling.
- Multiple future can not be chained together.

<details><summary><b>Operations</b></summary>
  
<p>
  
- **complete() :-** Lets you manually complete the future with the given value.
  - ```boolean results = comFuture.complete("hello world");```
  - ```CompletableFutureExample1.java```
  
- <b>thenApply() :-</b> Takes ```Function``` as argument and  Returns a new CompletionStage that, when this stage completes normally, is executed with this stage's result as the argument to the supplied function. 
    - ```CompletableFutureExample2```  
- <b>accept() :- </b> Takes Consumer as argument and return void CompletionStage ```CompletionState<void>```
   - ```CompletableFutureExample3```
  
</p>
</details>

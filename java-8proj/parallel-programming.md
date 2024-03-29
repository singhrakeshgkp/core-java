# Imperative and Functional Style programming
referred https://www.youtube.com/watch?v=0hQvWIdwnw4    (Venkat Subramaniam)
- imperative style
  - Has accidental complexity.
  - Structure of sequential code is very different from the structure of concurrent code.
  - Difficult to parallelize
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
- ```StreamVsParallelStreamEx6.java``` This will produce the output same way as parallel with map produced(discussed in StreamVsParallelStreamEx3,4,5 )
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

- Limitatons of future
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



# Completable Future Concept from Venkat Video
- Asynchronous Execution
  - Non Blocking -> We call a method and don't wait for result and proceed to do other works.
- Drawback of future
   ```
   Future<?> future = methodCall();
   ........
   future.get();//No more future
   ```
- Lessions from java script
  - callbacks
    - Lacks of consistency (no one can tell if the first parameter will be data or error. Someone may consider error as first and data as second. There is no universal way)
    - Hard to compose (method1->method2()->method3()...methodn(). each method send data through call back and asynchronous. its call callback hell) 
    - Hard to deal with errors(sometime we might get the error before method is ready to fire the callback, sometime get the error through the call back and its hard to know which one its gonna do) so java script moved to use Promises
  - promises
    - Promises may be in one of three states ```resolve, reject or pending```
     
     ```
	      Stream
		   dataflow
	      what is something goes wrong?
	      good luck
	     Promises
		two channel
		      data->.......
		      error->......
		-----f---------------------------------------------------data track
			 \                   /
		------------f------------f--------------------------------error track(treat error as another form of data)
		errors are first class citizens
      ```
       
       
 ### Completable Future
 - CompletableFuture in java is promises in java script
  - Stages -> each stages Return CompletableFuture there is no end
  - One stage completes and another stage may run
  - Creating completableFuture ```CompletableFutureExample4.java```
  - Get Vs GetNow  ```CompletableFutureExample5.java```
    - Get -> is a blocking, its very bad idea to use get(never ever use get)
    - GetNow -> It says if completable future has resolved get me the result if not then it will return the supplied value in getNow(0) here it is zero. Its also not good idea to use GetNow.
- Thread of execution ```CompletableFutureExample6.java```
  - If Future is finished its task before it get to a point (such as future.thenAccept) -> it will not switch the thread anymore it will run in main only 
  - If Future is not finished its task before it get to a point (such as future.thenAccept) -> Main thread will not wait and execution will happen in different thread.
- changing pool  ```CompletableFutureExample7.java```
- <b>Stream Vs CompletableFuture<b/>
  ```
  Stream					Completable Future
  Pipeline					pipeline
  lazy						lazy
  zero one or more data				zero or one
  only data channel				data channel and error channel
  foreach					thenAccept
  map						thenApply
  flatMap					thenCompose
  function returns data - use map               function returns data use thenApply/thenAccept...etc
  function returns stream - use flatmap         function returns CompletableFuture pipeline use thenCompose
  ```
	
- <b>Operations/Methods</b> ```CompletableFutureExample8.java```
  - thenAccept(consumer)
    - Returns CopletableFuture<Void>(completable future of void), and the status of the operation such as success, fail..etc
  - thenApply 
    - use to tranform the data.
- Creating pipeline and then completing ```CompletableFutureExample9.java```
- Dealing with Exception ```CompletableFutureExample10```
- Use of completeExceptionally method ```CompletableFutureExample11.java```
- Handling timeout (part of java 9)
  - suceed on time out(completeOnTimeout) ```CompletableFutureExample12.java```
  - fail on time out  ```CompletableFutureExample13.java```

- Combine ```CompletableFutureExample14.java```
- Compose ```CompletableFutureExample15.java```

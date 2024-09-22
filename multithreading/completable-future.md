# CompletableFuture

<p>

  Completable future introduced in java 8, it allows us to write non blocking, asynchronous code
   CompletableFuture is extension of ```Future``` api, it addressed the following concerns of Future api. When two or more threads attempt to complete, completeExceptionally, or cancel completableFuture only one of them succeeds.
 for more detials check java [doc](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html) 
</p>



## Future vs CompletableFuture
- **Blocking/NonBlocking**-> The key difference between future and CompletableFuture is that future is blocking whereas CompletableFuture is non-blocking. When dealing with future object you must have to call get() method to retrieve the result this method blocks until results is available. However with Completable future object u can use non blocking methods to retrieve results such as join(), thenApply() and thenAccept()...etc
- **Completiion** ->There is no way to explicitly complete the future,once u submit a task using executor service and get future object in return, you can only wait for task to complete. With completablefuture u have more control, u can complete it explicitly by calling complete(), cancel(), or completeExceptionally() method.
- **Composition** -> with future its is difficult to chain multiple asynchronous operation, or combine the results of multiple asynchronous operation. However with completable future we can do it easily using allof(), thencombine(), thenCompose() ... etc methods.
- **Exception Handling**-> With future while performing compution if exceptiion occurred in that case u have to  catch that explicitly. However with CompletableFuture you can handle exception in more elegant way using exceptionally() and handle() method 

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

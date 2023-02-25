### Imperative and Functional Style programming
- imperative style
  - Has accidental complexity.
  - Structure of sequential code is very different from the structure of concurrent code.
  - Difficult to paralelize
- Functional style
  - Has less complexity and easier to parallelize.
  - Structure of sequential code is identical to the structure of concurrent code
  - Easy to parallelize
- See ```ImpFunStyleEx1.java```

### Stream VS Parallel Stream
- ```StreamVsParallelStreamEx1.java```
- ```StreamVsParallelStreamEx2.java```
- Calling parallel and sequential both on the same pipeline ```StreamVsParallelStreamEx3.java```

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

# CompletableFuture

<p>
 CompletableFuture is extension of ```Future``` api, it addressed the following concerns of Future api. When two or more threads attempt to complete, completeExceptionally, or cancel completableFuture only one of them succeeds.
 for more detials check java [doc](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html) 
</p>

- There is no way to complete the future, we can only attempt to cancel the task
- The get method in ```Future``` is blocking operation
- No support for exception handling.
- Multiple future can not be chained together.

<summary><b>Operations</b></summary>
  
<p>
- **complete() :-** Lets you manually complete the future with the given value.
  - ```boolean results = comFuture.complete("hello world");```
  - ```CompletableFutureExample1.java```
  
  
</p>
</details>

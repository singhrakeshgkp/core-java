# CompletableFuture

<p>

  Completable future introduced in java 8, it allows us to write non blocking, asynchronous code
</p>

## Future vs CompletableFuture
- **Blocking/NonBlocking**-> The key difference between future and CompletableFuture is that future is blocking whereas CompletableFuture is non-blocking. When dealing with future object you must have to call get() method to retrieve the result this method blocks until results is available. However with Completable future object u can use non blocking methods to retrieve results such as join(), thenApply() and thenAccept()...etc
- **Completiion** ->There is no way to explicitly complete the future,once u submit a task using executor service and get future object in return, you can only wait for task to complete. With completablefuture u have more control, u can complete it explicitly by calling complete(), cancel(), or completeExceptionally() method.
- **Composition** -> with future its is difficult to chain multiple asynchronous operation, or combine the results of multiple asynchronous operation. However with completable future we can do it easily using allof(), thencombine(), thenCompose() ... etc methods.
- **Exception Handling**-> With future while performing compution if exceptiion occurred in that case u have to  catch that explicitly. However with CompletableFuture you can handle exception in more elegant way using exceptionally() and handle() method 

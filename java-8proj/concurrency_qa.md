**1. Q. How to stop a running thread in Java?**
   Ans. To stop a thread we can send an intrupt signal, requesting that a thread stop itself at next available opportunity. This means that thread could only signal other threads to stop not force them to stop. <br/>
**2. Q. Why is Thread.stop, Thread.suspend, or Thread.resume deprecated?**<br/>
   Ans. for more details please refer given [link](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/doc-files/threadPrimitiveDeprecation.html)<br/>
**3. What is Java Shutdown Hook?**<br/>
   Ans. The shutdown hook can be used to perform cleanup resource or save the state when JVM shuts down normally or abruptly. So if you want to execute some code before JVM shuts down, use shutdown hook.<br/>
   ```
   psvm([]args){
      System.out.println("Executing main Thread.");

         Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
               System.out.println("Executing Shutdown hook Thread.");
            }
         }));

         System.out.println("Exiting main thread.");
      }
   }
   ```

4. 

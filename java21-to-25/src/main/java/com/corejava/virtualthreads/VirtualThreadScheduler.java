package com.corejava.virtualthreads;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadScheduler {
  private Queue<CustomVirtualThread> queue = new ConcurrentLinkedQueue<>();
  private ExecutorService executor = Executors.newFixedThreadPool(3);
  public void start(){
    while (true){
      if(!queue.isEmpty()){
        var vt = queue.remove();
        executor.submit(vt::run);
      }
    }
  }

  public void schedule(CustomVirtualThread customVirtualThread){
    queue.add(customVirtualThread);
  }
}

package com.corejava.virtualthreads;

import java.util.function.Consumer;
import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class GeneratorEx {

  public static void main(String[] args) {
    var generator = new Generator<String>(source->{
      source.yield("A");
      source.yield("B");
      source.yield("c");
    });

    while(generator.hasNext()){
      System.out.println(generator.next());
    }
  }

  public static class Generator<T>{
    private ContinuationScope continuationScope;
    private Continuation continuation;
    private Source source;

    public boolean hasNext() {
      var value = !continuation.isDone();
      return value;
    }

    public T next() {
      var t =  source.getValue();
      continuation.run();
      return  t;
    }

    public class Source{
      private T value;
      public void yield(T t) {
        value = t;
        Continuation.yield(continuationScope);
      }

      private T getValue() {
        return  value;
      }
    }
    public Generator(Consumer<Source> consumer){
      continuationScope = new ContinuationScope("Test");
      continuation = new Continuation(continuationScope,()->consumer.accept(source));
      source = new Source();
      continuation.run();
    }
  }
}

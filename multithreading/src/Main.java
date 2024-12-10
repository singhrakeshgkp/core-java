import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) throws InterruptedException {

    AtomicInteger counter = new AtomicInteger(0);
    int size = 0;
    Queue<Integer> conn = new ConcurrentLinkedQueue<>();
    while(size<=2){
      size = counter.incrementAndGet();
      System.out.println(size);
    }
  }
}
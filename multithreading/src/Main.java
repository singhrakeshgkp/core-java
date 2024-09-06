//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) throws InterruptedException {
    Thread t1 =
        Thread.ofPlatform()
            .start(
                () -> {
                  System.out.println("counting 1 to 10 "+Thread.currentThread().getName());
                  for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                  }
                });

   // t1.join();
    System.out.println("T1 thread finished its execution");
  }
}
package com.stackoverflow;
/*
* if u run this application you will get StackOverFlowError, we can increase ThreadStack memory using -Xss20m means each ThreadStack will have max 20 mb memory
* this will not fix error as application is buggy, but you will get error after some more time
* */
public class StackOverFlowExample {
  public int counter = 0;
  public void startProcessing(){
    counter++;
    if (counter % 1000 ==0){
      IO.println(String.format("looped %s", counter) + " times");
    }
    startProcessing();
  }

  static void main() {
    StackOverFlowExample stackOverFlowExample = new StackOverFlowExample();
    stackOverFlowExample.startProcessing();
  }
}

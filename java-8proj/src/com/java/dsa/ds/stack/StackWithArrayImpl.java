package com.java.dsa.ds.stack;

public class StackWithArrayImpl {

  static  final int max = 10;
  int top;
  int[] numbers = new int[max];
  public  StackWithArrayImpl(){
    top = -1;
  }
  boolean isEmpty(){
    return top <0;
  }

  int pop(){
    if (isEmpty()){
      System.out.println("stack is underflow");
      return 0;
    }else {
      int num = numbers[top--];
      return num;
    }
  }

  boolean push(int item){
    if (top > (max)){
      System.out.println("stack is full");
      return false;
    }else {
      System.out.println(item + " pushed in stack");
      numbers[++top] = item;
      return true;
    }
  }

  int peek(){
    if(top < 0){
      System.out.println("stack is underflow");
      return 0;
    }else{
      int num = numbers[top];
      return  num;
    }
  }


  public static void main(String[] args) {
    StackWithArrayImpl obj = new StackWithArrayImpl();
    System.out.println(obj.push(11));
    System.out.println(obj.push(12));
    System.out.println(obj.push(13));
    System.out.println(obj.push(14));
    System.out.println(obj.push(15));
    System.out.println(obj.peek());
    System.out.println(obj.isEmpty());
    System.out.println(obj.pop());
  }
}

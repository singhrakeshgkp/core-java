package com.corejava.java25;

class Base{
  public Base(String name){
    IO.println("base constructor called");
    init();
  }

  private  void init(){
    IO.println("Base Init called");
  }
}

class Child extends  Base{
  public Child(String name){
    super(name);
    this.init();

  }

  public void init(){
    IO.println("child init called");
  }
}
public class FlexibleConstructorEx {

  static void main() {
    Child c = new Child("test");
  }
}

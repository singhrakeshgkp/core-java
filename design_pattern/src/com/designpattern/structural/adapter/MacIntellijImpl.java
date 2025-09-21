package com.designpattern.structural.adapter;

public class MacIntellijImpl implements  IMacIntellij   {


  @Override
  public void macShortKey() {
    System.out.println("Handling Intellij on mac machine");
  }
}

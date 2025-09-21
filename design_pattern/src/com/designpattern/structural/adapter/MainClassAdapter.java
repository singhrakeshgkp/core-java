package com.designpattern.structural.adapter;

import java.math.BigDecimal;

public class MainClassAdapter {
  public static void main(String[] args){
    IWindowsIntellij iWindowsIntellij = new WindowsIntellijImpl(); //provided windows machine to programmer
    iWindowsIntellij = new MacIntellijAdapter(new MacIntellijImpl());
    Programmer programmer = new Programmer(iWindowsIntellij);
    programmer.handleShortKey();
  }
}

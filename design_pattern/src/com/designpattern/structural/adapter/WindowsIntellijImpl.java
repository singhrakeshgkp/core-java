package com.designpattern.structural.adapter;

public class WindowsIntellijImpl implements IWindowsIntellij {


  @Override
  public void windowsShortKey() {
    System.out.println("Operating on windows machine with windows shortkey");
  }
}

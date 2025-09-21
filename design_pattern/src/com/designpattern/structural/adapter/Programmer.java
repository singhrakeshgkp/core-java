package com.designpattern.structural.adapter;

public class Programmer {
  private final IWindowsIntellij iWindowsIntellij;
  public Programmer(IWindowsIntellij iWindowsIntellij){
    this.iWindowsIntellij = iWindowsIntellij;
  }
  public void handleShortKey(){
    iWindowsIntellij.windowsShortKey();
  }
}

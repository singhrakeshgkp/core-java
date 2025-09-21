package com.designpattern.structural.adapter;

public class MacIntellijAdapter implements IWindowsIntellij {
  private final IMacIntellij macIntellij;

  public MacIntellijAdapter(IMacIntellij macIntellij){
    this.macIntellij = macIntellij;
  }
  @Override
  public void windowsShortKey() {
    macIntellij.macShortKey();
  }
}

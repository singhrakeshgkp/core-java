package com.designpattern.creational.factory;

public class MainClassFactoryPattern {
  public static void main(String[] args){

    Profession profession = ProfessionFactory.getProfessionInstance("Doctor");
   profession.msg();
  }
}

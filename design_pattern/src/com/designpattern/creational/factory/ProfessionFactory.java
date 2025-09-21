package com.designpattern.creational.factory;

public class ProfessionFactory {

  public static Profession getProfessionInstance(String profession) {
    return switch (profession) {
      case "Doctor" -> new Doctor();
      case "Engineer" -> new Engineer();
      case "Layer" -> new Layer();
      default -> throw new IllegalArgumentException("Not a valid profession");
    };
  }
}

package com.java20.feature;

public class SealedClassEx {

  public static void main(String[] args) {

    TrafficLight light = new RedLight();
    System.out.println("everything is ok");
  }
}

final class FlashingLight implements TrafficLight{}

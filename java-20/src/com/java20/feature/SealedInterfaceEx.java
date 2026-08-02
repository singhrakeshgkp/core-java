package com.java20.feature;

sealed interface TrafficLight permits RedLight,GreenLight,YellowLight,FlashingLight{

}

final class RedLight implements  TrafficLight{ }
final class  GreenLight implements TrafficLight{}
final class YellowLight implements  TrafficLight{}


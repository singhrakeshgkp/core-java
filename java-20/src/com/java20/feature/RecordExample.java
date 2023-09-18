package com.java20.feature;

public class RecordExample {

  public static void main(String[] args) {

    /*case 1 simple record*/
    /*Location location1 = new Location(1.22,1.33);
    Location location2 = new Location(1.22,1.33);
    Location location3 = new Location(1.33,1.33);
    System.out.println(location1); //toString implemented so will print value of both field
    System.out.println(location1.equals(location2));// equals method implemented so will print true
    System.out.println(location1==location2);// both are different object so will print false
    System.out.println(location1.equals(location3));// value of both object different so will print false*/

    /*case 2 writing methods in record*/
    /*Location location = new Location(1.22,1.33);
    System.out.println(location.msg());*/

    /*case3 specify the checks/validation on fields passed in constructor*/
    Location location = new Location(111.22,1.33);
    System.out.println(location);
  }
}
/*part of case 1*/
/*
record Location(double lat, double lon){

}*/

/*part of case 2*/
/*record Location(double lat, double lon){
public String msg(){
  return "hi hello";
}
}*/

/*part of case 3*/
record Location(double lat, double lon){
Location{
  if(lat>90)
    throw  new IllegalArgumentException("not a valid arguments");
}
}
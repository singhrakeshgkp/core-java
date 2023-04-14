package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsBVSEx4 {

    /*known as covariance where we can use object of derived class in place of base class
     * 
     * */
    public static void main(String[] args) {
	Banana4 banana = new Banana4();
	Orange4 orange = new Orange4();
	receiveFruit(banana);
	receiveFruit(orange);
	receiveBaskeOfFruits(new ArrayList<Fruit4>());
	//receiveBaskeOfFruits(new ArrayList<Orange4>()); compile time error, Liskov provide protection here
    }
    
    public static void receiveFruit(Fruit4 fruit) {
	System.out.println("Fruit Received "+fruit);
    }
    
   public static void receiveBaskeOfFruits(List<Fruit4> fruits) {
       System.out.println("received basket of fruits "+ fruits);
   }
}

class Fruit4{}
class Banana4 extends Fruit4{}
class Orange4 extends Fruit4{}
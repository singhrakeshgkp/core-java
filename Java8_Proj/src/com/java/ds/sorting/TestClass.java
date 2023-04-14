package com.java.ds.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class TestClass {
    public static void main(String[] args) {

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Banana());
        List<Banana> bananaList = new ArrayList<>();

    }

    public static void receiveBasketOfFruits(List<Fruit> fruits){
        System.out.println("received basket of fruits"+fruits);
    }

    public static  <T> void copy(List<T> from, List<? super T> to){
        for(T t: from){
            to.add(t);
        }
    }
}

class Fruit {}
class Banana extends Fruit{}
class Orange extends  Fruit{}
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
        Map<String,String> map = Map.of("1","rakesh","2","suresh");
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {

            }
        });
    }

}
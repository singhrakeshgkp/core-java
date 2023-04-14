package com.java.patternmatching;

public class PatternMattcherEx1 {

    public static String process(Object input){
        return switch (input){
            case Integer i ->"got an integer";
            default -> "no clue";
        };
    }

    public static void main(String[] args) {
        System.out.println(process(4444));
    }
}

package com.java.generics;

@Immutable
public class CustomAnnotationExample {
    
private final String msg;
private String txt;

public CustomAnnotationExample(String msg, String txt) {
    super();
    this.msg = msg;
    this.txt = txt;
}

public static void main(String[] args) {
    System.out.println("test");
}

}

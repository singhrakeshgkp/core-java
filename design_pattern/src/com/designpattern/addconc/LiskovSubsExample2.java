package com.designpattern.addconc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LiskovSubsExample2 {

    /*you can not throw new checked exception from derived class method.
     * its also implemented on framework level
     * */
    public static void process(List<Book3> books) {
	
    }
    public static void main(String[] args) {
	
    }
}

class Book2{ 
    
    public void readBook(String bookPath) {
	
    }
}

class TechBook2 extends Book2{
    
    public void readBook(String bookPath) {
	
    }
}
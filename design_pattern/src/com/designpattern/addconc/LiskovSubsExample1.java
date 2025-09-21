package com.designpattern.addconc;

import java.util.ArrayList;
import java.util.List;


public class LiskovSubsExample1 {

    /*Its implemented on framework level, that you can not be more restrictive in derived class
     * */
    public static void process(List<Book3> books) {
	
    }
    public static void main(String[] args) {}
}

class Book1{ 
    
    public String getBookName() {return "book";}
}

class TechBook1 extends Book1{
    
    //private is not possible here, as mentioned you can not be more restrictive in derived class
    public  String getBookName() {
	return "TechBook";
    }
}

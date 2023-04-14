package com.designpattern.addconc;

import java.util.ArrayList;
import java.util.List;

class Book3{ }

class TechBook3 extends Book3{}
public class LiskovSubsExample3 {

    /*Step 1- pass base type collection in the method argument
     *     output-> code will compile and run
     *Step 2- Pass derived type collection in the same method as argument
     *     output-> code will give compilation error
     * */
    public static void process(List<Book3> books) {
	
    }
    public static void main(String[] args) {
	
	/*step1 start*/
	List<Book3> books = new ArrayList<>();
	process(books);
	System.out.println("great it worked");
	
	/*step1 end*/
	
	/*step2 start*/
	List<TechBook3> techBooks = new ArrayList<>();
	//process(techBooks); will give compilation error 
	//because what if i had written code books.add(new Book) in process method
	/*step2 end*/
    }
}

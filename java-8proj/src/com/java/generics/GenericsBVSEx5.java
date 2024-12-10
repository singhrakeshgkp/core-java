package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsBVSEx5 {

    /*
     * Use object List of derived Generic class in place of List of base generic class
     * -> It will give compilation error
     * ->Copy1-> u can only read the value form "from" list and write to "to" list
     * */
    public static void main(String[] args) {
	
	List<Fruit5> fruits1 = new ArrayList<>();
	List<Fruit5> fruits2 = new ArrayList<>();
	
	List<Banana5> bananas1 = new ArrayList<>();
	List<Banana5> bananas2 = new ArrayList<>();
	copy(fruits1, fruits2);
	copy1(bananas1, fruits1); //this is also not possible with copy method but with copy1 we can do it
	//copy(fruits1, bananas1);// this is not possible
	
    }
    
   
   public static <T>void copy(List<T> from,List<T> to) {
       System.out.println("copy mehtod is called");
       for(var e : from) {
	   to.add(e);
       }
   }
   
   
   public static <T>void copy1(List<T> from,List<? super T> to) {
       System.out.println("copy1 mehtod is called");
       for(var e : from) {
	      to.add(e);
       }
   }
}

class Fruit5{}
class Banana5 extends Fruit5{}
class Orange5 extends Fruit5{}
package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsBVSEx6 {

    /*
     * what is type erasure?
     * compiler do some analysis to decide that what the type of that variable should be
     * if it do not find anything appropriate, this assume this is going to become 
     * class MyList<Object>
     * In case of MyList2 type will become MyList2<Comparable<Object>. 
     * In case of MyList3 it will become MyList3<Foo>
     * So we can say based on the context it can infer the type
     * */
    public static void main(String[] args) {
	
		
   
   }
}

class MyList<T>{
    public static void foo() {
	System.out.println("foo called");
    }
}

class MyList2<T extends Comparable<T>>{// class MyList2<Comparable<Object>
    public static void foo() {
	System.out.println("foo called");
    }
}

class MyList3<T extends Foo>{// class MyList2<Foo>
    public static void foo() {
	System.out.println("foo called");
    }
}
class Foo{
    
}
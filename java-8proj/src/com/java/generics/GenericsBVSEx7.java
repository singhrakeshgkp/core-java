package com.java.generics;

public class GenericsBVSEx7 {

    /* msg("Hello");-> This will work
     * msg(new GenericsBVSEx7());-> This will also work
     * System.out.println(new T()); here we are instantiating parameterized type which is not
     * allowed in java because of type erasure. If it was allowed this (new T()) would become
     * new Object() which is kind of silly
     * */
    
    public static <T> void msg(T instance) {
	System.out.println(instance);
	//System.out.println(new T());// This will not work
    }
    public static void main(String[] args) {
     msg("Hello");
     msg(new GenericsBVSEx7());
   }
    
}

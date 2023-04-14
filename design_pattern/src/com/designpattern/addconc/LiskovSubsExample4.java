package com.designpattern.addconc;

import java.util.List;


public class LiskovSubsExample4 {

    /*Task1- you have to bring in a class with very similar function that is in another class.
     * solution-> use inheritance depicted in A1 and B1
     *Task2-> Problem with the above approach is that we have committed lot of burden that can obj of A1
     *        can be used in place of B1 without knowing
     *solution-> use composition instead inheritance  refer A1 and B2, here lot of typing involve,
     *           you have to write each function in B2 and so on(this can be refactor using IDE )
     * if we use inheritance in this case we violate LSP
     * if we are not using inheritance we are violating two principle
     * 1. DRY(as we duplicated the efforts)
     * 2. OCP (if someone change parent class function name it will start giving compile time error)
     * 
     * now question is, should i violate LSP or DRY and OCP?
     * ans is violate 2 DRY and OCP because if u violate LSP you might violate DRY and OCP but if u violate DRY an OCP there is no change to violate LSP
     * 
     * 
     *           
     * */
   
    public static void main(String[] args) {
	
    }
}

class A1{
    public void f1() {}
    public int f2() {return 0;}
}

class B1 extends A1 {
    
    //should have f1,f2(same as in A1) and f3
    
    public void f3() {}
}

class B2{
    private A1 obj = new A1();
    
    public void f1() {obj.f1();}
    public int f2() {return obj.f2();}
    public void f3() {}
}
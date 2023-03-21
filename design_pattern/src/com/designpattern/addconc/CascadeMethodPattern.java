package com.designpattern.addconc;

public class CascadeMethodPattern {

    /*1. fun1 using verbose code
     *2. fun2 removed verbosity , for this it uses cascade method pattern
     * disadvantage with cascade method pattern is that (what do we do with mailer once we are done with it
     *  should be reuse it, should be throw it away. its not very clear what to do with it this is where we
     *  could combine it with lambda to remove this concern)
     *  
     *  Task 3- refer code{FluentInterfaceEx1}
     * 
     * 
     * */
    
    public static void fun1() {
	Mailer1 mailer = new Mailer1();
	mailer.from("abc@gmail.com");
	mailer.to("xyz@gmail.com");
	mailer.body("test");
	mailer.send();
    }
    
    public static void fun2() {
   	new Mailer2()
        .from("abc@gmail.com")
   	.to("xyz@gmail.com")
   	.body("test")
   	.send();
       }
    public static void main(String[] args) {
	//fun1();
	fun2();
	
    }
}


class Mailer1{
    
    public void from(String from) {System.out.println("from ....");}
    public void to(String to) {System.out.println("to ....");}
    public void subject(String from) {System.out.println("subject ....");}
    public void body(String from) {System.out.println("body ....");}
    public void send() {System.out.println("sending ....");}
}

class Mailer2{
    
    public Mailer2 from(String from) {System.out.println("from ...."); return this;}
    public Mailer2 to(String to) {System.out.println("to ....");return this;}
    public Mailer2 subject(String from) {System.out.println("subject ....");return this;}
    public Mailer2 body(String from) {System.out.println("body ....");return this;}
    public void send() {System.out.println("sending ....");}
}

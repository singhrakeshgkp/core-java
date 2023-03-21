package com.designpattern.addconc;

import java.util.function.Consumer;

public class FluentInterfaceEx1 {

    public static void main(String[] args) {
	Mailer3.send(mailer->mailer
        .from("abc@gmail.com")
   	.to("xyz@gmail.com")
   	.body("test"));
   	
    }
}


class Mailer3{
    
    private Mailer3() {}
    public Mailer3 from(String from) {System.out.println("from ...."); return this;}
    public Mailer3 to(String to) {System.out.println("to ....");return this;}
    public Mailer3 subject(String from) {System.out.println("subject ....");return this;}
    public Mailer3 body(String from) {System.out.println("body ....");return this;}
    public static void send(Consumer<Mailer3> block) {
	var mailer = new Mailer3();
	block.accept(mailer);
	System.out.println("sending ....");
	
	}
}

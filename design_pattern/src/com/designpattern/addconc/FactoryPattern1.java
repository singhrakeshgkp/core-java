package com.designpattern.addconc;

interface Pet{}
class Dog implements Pet{}
class Cat implements Pet{}


interface Person{
    Pet getPet();
    default void play() {
	System.out.println("Playing with pet "+getPet());
    }
}

class DogPerson implements Person{

    private Dog dog = new Dog();
    @Override
    public Pet getPet() {
	return dog;
    }
 }
class CatLover implements Person{

    private Cat cat = new Cat();
    @Override
    public Pet getPet() {
	return cat;
    }
    
}
public class FactoryPattern1 {

    public static void call(Person person) {
	person.play();
    }
    public static void main(String[] args) {
	call(new DogPerson());
	call(new CatLover());
    }
}



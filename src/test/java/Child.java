package test.java;

class Base{
    Base(){
        //overrideMe();
        populate1();
    }
    //abstract void overrideMe();
    public void populate1(){
        System.out.println("in super class" + this.getClass().toString());
    }
}
public class Child {
    Child(){
        super();
        System.out.println("In child class constructor.");
        overrideMe();
        populate();
    }
    void overrideMe(){
        System.out.println("In child class overrideMe method.");
    }

    void populate(){
        System.out.println("In child class populate method.");
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}

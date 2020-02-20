package constructor.pak2;

import constructor.pak1.Parent;

public class Child extends Parent {
    public Child(int d) {
        /**
         * Using super() Parent Class protected constructor can be called
         */
        //super();
        System.out.println("Child Constructor called");
    }
    public void childDisp() {
        System.out.println("Child Disp called");
    }
    public static void main(String args[]) {
        Child p = new Child(4);
    }
}

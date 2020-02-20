package java_basics.interface_test.multiple_interitance_for_static;

interface MyInterface1{
    static void display(){
        System.out.println("Static Method in MyInterface1");
    }
}

interface MyInterface2{
    static void display(){
        System.out.println("Static Method in MyInterface2");
    }
}
public class TestMultipleStaticInterface implements MyInterface1, MyInterface2{
    public static void main(String[] args) {
        MyInterface1.display();
        MyInterface2.display();
    }
}

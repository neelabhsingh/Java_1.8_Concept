package java_basics.interface_test.interface_demo;


interface MyInterface{
    default void newMethod(){
        System.out.println("Newly added default method");
    }
    static void anotherNewMethod(){
        System.out.println("Newly added static method");
    }
    void existingMethod(String str);
}
public class InterfaceDemo implements MyInterface{
    @Override
    public void existingMethod(String str) {
        System.out.println("String is :" + str);
    }

    public static void main(String[] args) {
        InterfaceDemo interfaceDemo = new InterfaceDemo();
        interfaceDemo.existingMethod("Existing method");
        interfaceDemo.newMethod();
        MyInterface.anotherNewMethod();
    }
}

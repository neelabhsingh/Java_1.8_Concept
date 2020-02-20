package java_basics.interface_test.multiple_interitance_demo;
interface MyInterface1{
    default void newMethod(){
        System.out.println("Newly added default method added in MyInterface1");
    }
    void existingMethodInMyInterface1(String str);
}
interface MyInterface2{
    default void newMethod(){
        System.out.println("Newly added default method added in MyInterface2");
    }
    void existingMethodInMyInterface2(String string);
}
public class MultipleInheritanceTestForInterface implements MyInterface1, MyInterface2{
    @Override
    /*
    * The multiple inheritance problem can occur, when we have two interfaces with the
    * default methods of same signature. To solve this problem, we can implement this
    * method in the implementation class like following:
     * */
    public void newMethod() {
        System.out.println("This default method in both Interfaces. To solve this problem, we can implement this method in the implementation class like following.");
    }

    @Override
    public void existingMethodInMyInterface1(String str) {
        System.out.println("Existing Method in MyInterface1");
    }

    @Override
    public void existingMethodInMyInterface2(String string) {
        System.out.println("Existing Method in MyInterface2");
    }

    public static void main(String[] args) {
        MultipleInheritanceTestForInterface obj = new MultipleInheritanceTestForInterface();
        obj.existingMethodInMyInterface1("Interface1");
        obj.existingMethodInMyInterface2("Interface2");
        obj.newMethod();
    }
}

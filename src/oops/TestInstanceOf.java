package oops;
interface Interface1{
    void method1();
}
class A implements Interface1{
    @Override
    public void method1() {
        System.out.println("Implementation of method1");
    }
}
class B extends A{

}
class C extends A{

}
public class TestInstanceOf {
    public static void main(String[] args) {
        Interface1 objA = new A();
        Interface1 objB = new B();
        Interface1 objC = new C();
        B ref = (B) objC;
    }
}

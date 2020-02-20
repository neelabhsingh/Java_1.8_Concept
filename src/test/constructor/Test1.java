package test.constructor;

public class Test1 {
    public static void main(String[] args) {
//        B b = new B("123");
//        System.out.println(b.pp);
    }
}
class A{
    String ss;
    public A(String ss) {
        this.ss = ss;
    }
}
//class B extends A{
//    String pp;
//    public B(String pp) {
//        this.pp = pp;
//    }
//}

/*
* Output
* 1. Compile Time Error
* 2. Runtime Error
* 3. Runtime Exception
* 4. The given program will run successfully.
* */
package test.excpetion;

public class Test1 {
    public static void main(String[] args) {
        try {
            int data = 25/0;
        }finally {
            System.out.println("Finally Block is always executed.");
        }
//        catch (ArithmeticException ex){
//
//        }
    }
}
/*
* Output: Compile time error.
* */
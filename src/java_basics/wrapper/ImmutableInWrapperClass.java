package java_basics.wrapper;

public class ImmutableInWrapperClass {
    public static void main(String[] args) {
        Integer i = new Integer(12);
        System.out.println(i);
        modify(i);
        System.out.println(i);
    }
    private static void modify(Integer i){
        i = i + 1;
    }
}
/*
*
* Output
* 12
* 12
Explanation:
All primitive wrapper classes (Integer, Byte, Long, Float, Double, Character, Boolean and Short) are
* immutable in Java, so operations like addition and subtraction create a new object and not modify the old.

The below line of code in the modify method is operating on wrapper class Integer, not an int

i = i + 1;

It does the following:

Unbox i to an int value
Add 1 to that value
Box the result into another Integer object
Assign the resulting Integer to i (thus changing what object i references)
Since object references are passed by value, the action taken in the modify method does not change
* i that was used as an argument in the call to modify. Thus the main routine still prints 12 after
* the method returns.
* */
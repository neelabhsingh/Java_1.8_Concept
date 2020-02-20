package constructor;

public class FinalConstructor {
//    final public FinalConstructor() { // Error:(4, 18) java: modifier final not allowed here
//    }
    /*
    When you set a method as final, then” The method cannot be overridden by any class”,
    but Constructor by JLS ( Java Language Specification ) definition can’t be overridden.
    A constructor is not inherited, so there is no need for declaring it as final.
     */
    public FinalConstructor(int a) {
    }

    public static void main(String[] args) {
        FinalConstructor finalConstructor = new FinalConstructor(2);

    }
}

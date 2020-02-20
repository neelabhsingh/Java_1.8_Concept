package generics;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Name");
        list.add(1);
        list.add(2.3);
        String name = (String) list.get(0);
        System.out.println(name);
        //Output: No Error, Name
        String integerValue = (String) list.get(1);
        System.out.println(integerValue);
        //Output: Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
    }
}

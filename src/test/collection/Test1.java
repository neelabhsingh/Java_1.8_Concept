package test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("16");
        list.add("7");
        list.add("9");
        list.add("1");
        Collections.sort(list);
        list.forEach((a) -> System.out.println(a));
    }
}

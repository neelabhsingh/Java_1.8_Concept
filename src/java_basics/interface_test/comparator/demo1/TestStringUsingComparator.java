package java_basics.interface_test.comparator.demo1;

import java.util.Arrays;
import java.util.Comparator;

public class TestStringUsingComparator {
    public static void main(String[] args) {
        String[] friends = { "Peter", "Paul", "Mary" };
        System.out.println("Sort the Arrays dictionary order.");
        Arrays.sort(friends);
        for(String name : friends){
            System.out.print(name +", ");
        }
        System.out.println();
        System.out.println("Sort the Arrays in decreasing order of length.");
        Arrays.sort(friends, new LengthComparator().reversed());
        for(String name : friends){
            System.out.print(name +", ");
        }
    }
}
class LengthComparator implements Comparator<String>{
    @Override
    public int compare(String s, String t1) {
        return s.length() - t1.length();
    }
}
package collections.hashmap;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        String value1 =  hash_map.put(10, "Geeks");
        hash_map.put(6, "Welcome");
        String value2 = hash_map.put(6, "Bye");
        System.out.println("Value1: " + value1);
        System.out.println("Value2: " + value2);
    }
}

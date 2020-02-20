package test.java;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Example {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        Iterator<String> itr = myList.iterator();
        while (itr.hasNext()){
            String value = itr.next();
            System.out.println("List value :" + value);
            if(value.equals("3")){
                myList.remove(value);
            }
        }

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");
        Iterator<String> itr1 = myMap.keySet().iterator();
        while (itr1.hasNext()){
            String key = itr1.next();
            System.out.println("Map Value :" + myMap.get(key));
            if(key.equals("2")){
                myMap.put("1", "4");
            }
        }
    }
}

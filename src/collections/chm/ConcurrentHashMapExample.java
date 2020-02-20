package collections.chm;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
        chm.put("Apple", "iPhone6");
        chm.put("HTC", "HTC One");
        chm.put("Samsung", "S6");
        Iterator iterator = chm.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(chm.get(iterator.next()));
            chm.put("Sony", "Xperia Z");
        }
    }
}

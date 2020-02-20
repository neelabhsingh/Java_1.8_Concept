package collections.exception;

import java.util.Arrays;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4);
        for(Integer integer : integers){
            if(integer == 2){
                integers.remove(1);
            }
        }
    }
}
/*
* Output:
* Exception in thread "main" java.lang.UnsupportedOperationException
	at java.util.AbstractList.remove(AbstractList.java:161)
	at java.util.AbstractList$Itr.remove(AbstractList.java:374)
	at java.util.AbstractCollection.remove(AbstractCollection.java:293)
	at collections.exception.ConcurrentModificationException.main(ConcurrentModificationException.java:11)
* */

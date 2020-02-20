package collections.copyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<String>();
        threadSafeList.add("Java");
        threadSafeList.add("J2EE");
        threadSafeList.add("Collection");
        Iterator<String> itr = threadSafeList.iterator();
        while (itr.hasNext()){
            System.out.println("Value " + itr.next());
            itr.remove();  // Just uncomment this line otherwise get following error,  remove operator is not supported by CopyOnWriteArrayList iterator
        }
    }
}
/* Output:
* Value Java
Exception in thread "main" java.lang.UnsupportedOperationException
	at java.util.concurrent.CopyOnWriteArrayList$COWIterator.remove(CopyOnWriteArrayList.java:1178)
	at collections.copyOnWriteArrayList.Demo.main(Demo.java:15)
* */

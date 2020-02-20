package concurrent_test.atomic_operation;

import java.util.concurrent.atomic.AtomicInteger;

class Shared{
    static AtomicInteger ai = new AtomicInteger(0);
}
class AtomicThread implements Runnable{
    String name;

    public AtomicThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        for(int i=1; i<=3; i++){
            System.out.println(name +" got: " + Shared.ai.incrementAndGet());
        }
    }
}
public class AtomicDemo {
    public static void main(String[] args) {
        new Thread(new AtomicThread("A")).start();
        new Thread(new AtomicThread("B")).start();
        new Thread(new AtomicThread("C")).start();
    }
}

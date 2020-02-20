package multithreading.reentrant_lock;

import com.sun.xml.internal.ws.api.client.WSPortInfo;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private void increment(){
        for(int i=0; i<10000; i++){
            count++;
        }
    }
    public void firstThread() throws InterruptedException{
        lock.lock();
        System.out.println("Waiting .....");
        cond.await();
        System.out.println("Woken up ....");
        try {
            increment();
        }finally {
            lock.unlock();
        }
    }
    public void secondThread() throws InterruptedException{
        Thread.sleep(1000);
        lock.lock();
        System.out.println("Press the return Key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got the return Key!");
        cond.signal();
        try {
            increment();
        }finally {
            lock.unlock();
        }
    }
    public void finish(){
        System.out.println("Count value: " + count);
    }
}

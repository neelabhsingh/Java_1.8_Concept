package concurrent_test.rentrant_lock_demo;

import java.util.concurrent.locks.ReentrantLock;

class LockThread implements Runnable{
    String name;
    ReentrantLock lock;

    public LockThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try{
            System.out.println(name +" " + "is waiting to lock count.");
            lock.lock();
            System.out.println(name + " is locking count.");
            Shared.count++;
            System.out.println("Thread Name "+ name +": " + Shared.count);
            System.out.println(name +" is sleeping.");
            Thread.sleep(1000);
        }catch (InterruptedException exc){
            System.out.println(exc);
        }finally {
            System.out.println("Thread "+ name + " is unlocking the count.");
            lock.unlock();
        }
    }
}
class Shared{
    static int count = 0;
}
public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new LockThread("A", lock)).start();
        new Thread(new LockThread("B", lock)).start();
    }
}

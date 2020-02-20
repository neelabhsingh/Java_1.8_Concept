package multithreading.print_sequence_3_threads_2;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadNumberPrinter {

    Object monitor = new Object();
    AtomicInteger number = new AtomicInteger(1);

    public static void main(String[] args) {
        ThreadNumberPrinter tnp = new ThreadNumberPrinter();
        Thread t1 = new Thread(tnp.new Printer(0));
        Thread t2 = new Thread(tnp.new Printer(1));
        Thread t3 = new Thread(tnp.new Printer(2));

        t3.start();
        t1.start();
        t2.start();
    }

    class Printer implements Runnable {
        int threadId;
        public Printer(int id) {
            threadId = id;
        }

        public void run() {
            print();
        }

        private void print() {
            try {
                while (true) {
                    Thread.sleep(1000l);
                    synchronized (monitor) {
                        if (number.get() % 3 != threadId) {
                            monitor.wait();
                        } else {
                            System.out.println("ThreadId [" + threadId
                                    + "] printing -->"
                                    + number.getAndIncrement());
                            monitor.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

package multithreading.odd_even;

public class PrintOddEven{
    public static void main(String[] args) {
        SharedPrinter sharedPrinter = new SharedPrinter();
        OddThread oddThread = new OddThread(10, sharedPrinter);
        EvenThread evenThread = new EvenThread(10, sharedPrinter);
        oddThread.start();
        evenThread.start();
        try {
            oddThread.join();
            evenThread.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }
}
class OddThread extends Thread {
    int limit;
    SharedPrinter printer;

    public OddThread(int limit, SharedPrinter printer) {
        this.limit = limit;
        this.printer = printer;
    }

    @Override
    public void run() {
        int oddNumber = 1;
        while (oddNumber < limit){
            printer.printOdd(oddNumber);
            oddNumber += 2;
        }
    }
}
class EvenThread extends Thread {
    int limit;
    SharedPrinter printer;

    public EvenThread(int limit, SharedPrinter printer) {
        this.limit = limit;
        this.printer = printer;
    }

    @Override
    public void run() {
        int evenNumber = 2;
        while (evenNumber < limit){
            printer.printEven(evenNumber);
            evenNumber +=2;
        }
    }
}

class SharedPrinter{
    boolean isOddPrinter = false;
    synchronized void printOdd(int number){
        while (isOddPrinter){
            try {
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + number);
        isOddPrinter = true;
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        notify();
    }
    synchronized void printEven(int number){
        while (!isOddPrinter){
            try {
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + number);
        isOddPrinter = false;
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        notify();
    }
}
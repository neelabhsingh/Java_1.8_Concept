package multithreading.oddeven;

class Printer{
    private volatile boolean isOdd;
    synchronized void printEven(int number){
        while (!isOdd){
            System.out.println("TEST");
            try {
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +":" + number);
        isOdd = false;
        notify();
    }
    synchronized void printOdd(int number){
        while (isOdd){
            try {
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +":" + number);
        try {
            Thread.sleep(5000);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        isOdd = true;
        notify();
    }
}
class EvenOddThread implements Runnable{
    private int maxRange;
    private Printer printer;
    private boolean isEvenNumber;

    public EvenOddThread(int maxRange, Printer printer, boolean isEvenNumber) {
        this.maxRange = maxRange;
        this.printer = printer;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= maxRange){
            if(isEvenNumber) {
                printer.printEven(number);
            }else{
                printer.printOdd(number);
            }
            number += 2;
        }
    }
}

public class OddEvenTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread oddThread = new Thread(new EvenOddThread(10,  printer, false));
        Thread evenThread = new Thread(new EvenOddThread(10,  printer, true));
        oddThread.start();
        evenThread.start();
    }
}

package multithreading.print_number.demo1;

public class PrintNumber {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(new PrintEvenOdd(20, printer, false ), "Odd");
        Thread t2 = new Thread(new PrintEvenOdd(20, printer, true ), "Even");
        t1.start();
        t2.start();
    }
}

class PrintEvenOdd implements Runnable{
    public PrintEvenOdd(int max, Printer printer, boolean isEvenNumber) {
        this.max = max;
        this.printer = printer;
        this.isEvenNumber = isEvenNumber;
    }

    private int max;
    private Printer printer;
    private boolean isEvenNumber;
    @Override
    public void run() {
        int number = isEvenNumber ? 2: 1;
        while (number <= max){
            if(isEvenNumber){
                printer.printEven(number);
            }else {
                printer.printOdd(number);
            }
            number+=2;
        }
    }
}
class Printer{
    private volatile boolean isOdd;
    synchronized void printOdd(int number){
        while (isOdd){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : " + number);
        isOdd = true;
        notify();
    }
    synchronized void printEven(int number){
        while (!isOdd){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : " + number);
        isOdd = false;
        notify();
    }
}

package multithreading.demo;

class Demo1 extends Thread{
    @Override
    public void run() {
        System.out.println("Demo1");
    }
}
class Demo2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Demo2");
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Begin");
        new Demo1().start();
        new Thread(() -> System.out.println("Start")).start();
        System.out.println("End");
    }
}

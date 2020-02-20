package lambda.multithreading;

class Thread1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Without Lambda Expression.");
    }
}

public class LambdaInMultithreading{
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        t1.start();
        new Thread(() -> {
            System.out.println("Thread with Lambda expression.");
        }).start();
    }
}

package multithreading.odd_even;

public class InterruptExample {
    public static void main(String[] args) throws  InterruptedException {
       InterruptExample.example();
    }
    public static void example() throws InterruptedException{
        final Thread sleepyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("I want to sleep for an hour");
                    Thread.sleep(1000 * 60 * 60);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        });
        sleepyThread.start();
        System.out.println("About to wake up the sleepy thread");
        sleepyThread.interrupt();
        System.out.println("Wake up sleepy thread");
        sleepyThread.join();
    }
}

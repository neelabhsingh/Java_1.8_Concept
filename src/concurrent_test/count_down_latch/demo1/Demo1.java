package concurrent_test.count_down_latch.demo1;

import java.util.concurrent.CountDownLatch;

public class Demo1 {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);// Change it to 3 -> 1 see the effect.
        Thread cacheService = new Thread(new Service("CacheService", 1000, countDownLatch));
        Thread alterService = new Thread(new Service("AlterService", 1000, countDownLatch));
        Thread validationService = new Thread(new Service("ValidationService", 1000, countDownLatch));
        cacheService.start();
        alterService.start();
        validationService.start();
        try {
            countDownLatch.await();
            System.out.println("All service is up, Application is starting now");
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}

class Service implements Runnable{
    private final String name;
    private final int timeToStart;
    private final CountDownLatch countDownLatch;

    public Service(String name, int timeToStart, CountDownLatch countDownLatch) {
        this.name = name;
        this.timeToStart = timeToStart;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(name+" is Up");
        countDownLatch.countDown();
    }
}
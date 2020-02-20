package concurrent_test.producer_consumer.blacking_queue1;

import java.util.concurrent.*;

public class ProducerConsumerExecutorService {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable producedTask = () -> {
            try{
                int value = 0;
                while (true){
                    blockingQueue.put(value);
                    System.out.println("Produced " + value);
                    value++;
                    Thread.sleep(1000);
                }
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        };
        Runnable consumerTask = () ->{
            try {
                while (true){
                    int value = blockingQueue.take();
                    System.out.println("Consume " + value);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        };
        executorService.execute(producedTask);
        executorService.execute(consumerTask);
        executorService.shutdown();
    }
}

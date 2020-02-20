package concurrent_test.thread_pool;

import java.util.Calendar;
import java.util.concurrent.*;

public class Demonstration {
    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Sum :" + findSum(100));
        threadPool.shutdown();
    }
    static int findSum(int n) throws ExecutionException, InterruptedException {
        Callable<Integer> sumTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i=0; i< n; i++){
                    sum += i;
                }
                return sum;
            }
        };
        Future<Integer> future = threadPool.submit(sumTask);
        return future.get();
    }
}

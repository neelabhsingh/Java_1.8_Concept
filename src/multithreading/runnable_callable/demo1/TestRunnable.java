package multithreading.runnable_callable.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

class EvenLoggingTask implements Runnable{
    @Override
    public void run() {

    }
}

public class TestRunnable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new EvenLoggingTask());
        executorService.shutdown();
    }
}

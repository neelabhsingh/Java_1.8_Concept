package concurrent_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class WorkerThread implements Runnable{
    String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " start. "+ "Command "+ command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+ " end. "+ "Command ");
    }
    private void processCommand(){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();

        }
    }
}

public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0; i< 10; i++){
            Runnable worker = new WorkerThread("" + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("Finished all Thread.");
    }
}

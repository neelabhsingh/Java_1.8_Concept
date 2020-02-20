package lambda.blocking_queue;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException{
        final MyBlockingQueue<Integer> q = new MyBlockingQueue(3);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0 ; i< 50; i++){
                        q.enqueue(new Integer(i));
                        System.out.println("enqueue " + i);
                    }
                }catch (InterruptedException ex){

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0; i<25; i++){
                        Integer item = q.dequeue();
                        System.out.println("Thread 2 dequeued: " + item);

                    }
                }catch (InterruptedException ex){

                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0; i<25; i++){
                        Integer item = q.dequeue();
                        System.out.println("Thread 2 dequeued: " + item);

                    }
                }catch (InterruptedException ex){

                }
            }
        });
        t1.start();
        Thread.sleep(4000);
        t2.start();

        t2.join();

        t3.start();
        t1.join();
        t3.join();
    }
}

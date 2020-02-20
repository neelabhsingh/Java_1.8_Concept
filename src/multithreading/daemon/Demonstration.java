package multithreading.daemon;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        Thread thread = new Thread(executeMe);
        thread.setDaemon(true);
        thread.start();
        thread.join();
    }
}
class ExecuteMe implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("Say hello over and over again");
            try {
                Thread.sleep(5000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}

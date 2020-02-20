package interview;

import java.util.*;
import java.util.concurrent.*;

public class Stats {
    static class Stack{
        double sum;
        int count;
        public Stack(double avg, int count){
            this.sum = avg;
            this.count = count;
        }
    }
    static HashMap<String, Stack> hashMap = new HashMap<>();
    public static class StatisticsAggregatorImpl implements StatisticsAggregator {


        @Override
        public void putNewPrice(String symbol, double price) {
            if(!hashMap.containsKey(symbol)){
                Stack stack = new Stack(price, 1);
                hashMap.put(symbol, stack);
            }else{
                Stack stack = hashMap.get(symbol);
                stack.sum += price;
                stack.count++;
                hashMap.put(symbol, stack);
            }
        }

        @Override
        public double getAveragePrice(String symbol) {
            if(hashMap.containsKey(symbol)){
                Stack stack = hashMap.get(symbol);
                return stack.sum / (double) stack.count ;
            }
            return 0.0;
        }

        @Override
        public int getTickCount(String symbol) {
            if(hashMap.containsKey(symbol)) {
                Stack stack = hashMap.get(symbol);
                return stack.count;
            }
            return 0;
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price.
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            int threads = Integer.parseInt(inputs[0]);
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        stats.putNewPrice(symbol, price);
                    }
                });

            }
            pool.shutdown();
            try {
                pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (String symbol : symbols) {
                System.out.println(String.format("%s %.4f %d", symbol,
                        stats.getAveragePrice(symbol),
                        stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }
}
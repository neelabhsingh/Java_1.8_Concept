package collections.priority_queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(30);
        priorityQueue.add(60);
        priorityQueue.add(11);
        priorityQueue.add(8);
        priorityQueue.add(31);
        priorityQueue.add(90);
        Comparator comparator = priorityQueue.comparator();
        System.out.println(comparator);
        Iterator itr = priorityQueue.iterator();
        System.out.println("Iterate PriorityQueue.");
        while (itr.hasNext()){
            System.out.print(itr.next() +", ");
        }
        System.out.println();
        System.out.println("Assess using poll operation.");
        while (priorityQueue.size() >0){
            System.out.print(priorityQueue.poll() + ", ");
        }
    }
}


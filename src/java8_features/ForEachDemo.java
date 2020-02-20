package java8_features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i< 10; i++){
            myList.add(i);
        }
        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()){
            Integer i = it.next();
            System.out.println("Iterator Value " +i);
        }
        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("forEach anonymous class value " +t);
            }
        });
        MyConsumer action = new MyConsumer();
        myList.forEach(action);
    }
}
class MyConsumer implements Consumer<Integer>{
    @Override
    public void accept(Integer integer) {
        System.out.println("Consumer Impl Value " + integer);
    }
}
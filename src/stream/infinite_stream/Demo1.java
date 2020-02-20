package stream.infinite_stream;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Create an infinite stream of elements from zero that will be incremented by two.
Then we need to limit that sequence before calling terminal operation.
It is crucial to use a limit() method before executing a collect() method that is a
terminal operation, otherwise our program will run indefinitely:
 */
public class Demo1 {
    public static void main(String[] args) {
        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i+1);
        List<Integer> collect = infiniteStream.limit(10).collect(Collectors.toList());
        Iterator itr = collect.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next() +", ");
        }
        System.out.println();
        //List<Integer> collect1 = infiniteStream.skip(10).limit(10).collect(Collectors.toList());
        //infiniteStream is already used can't be again use.
        Stream<Integer> integerStream2 = Stream.iterate(0, i->i+1);
        List<Integer>  collect2 = integerStream2.skip(10).limit(10).collect(Collectors.toList());
        itr = collect2.iterator();
        /*
        We use a skip() transformation to discard first 10 results and take the next 10 elements.
        We can create an infinite stream of any custom type elements by passing a function of a
        Supplier interface to a generate() method on a Stream.
         */
        while (itr.hasNext()){
            System.out.print(itr.next()+", ");
        }
    }
}

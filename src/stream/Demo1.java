package stream;

import java.util.Date;
import java.util.stream.Stream;

public class Demo1 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,5,6,7,9);
        //stream.forEach(p -> System.out.println(p));
        Stream<Integer> stream1 = Stream.of(new Integer[] {1,2,3,4,5,6,7,8,9});
        stream1.forEach(p-> System.out.print(p +","));

        Stream<Date> stream2 = Stream.generate(() -> {return new Date();});
        stream2.forEach(p -> System.out.println(p));
    }
}

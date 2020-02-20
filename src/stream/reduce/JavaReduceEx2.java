package stream.reduce;

import java.util.stream.IntStream;

public class JavaReduceEx2 {
    public static void main(String[] args) {
        IntStream.range(1,10).reduce((x, y) -> x +y).ifPresent(System.out::println);
        IntStream.range(1,10).reduce(Integer::sum).ifPresent(System.out::println);
    }
}

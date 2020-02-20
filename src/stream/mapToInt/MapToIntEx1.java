package stream.mapToInt;

import java.util.Arrays;
import java.util.List;

public class MapToIntEx1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("3", "6", "8",
                "14", "15");
        list.stream().filter(num -> Integer.parseInt(num) % 3== 0).forEach(System.out::println);
        System.out.println("Convert into integer");
        list.stream().mapToInt(num -> Integer.parseInt(num)).forEach(System.out::println);
    }
}

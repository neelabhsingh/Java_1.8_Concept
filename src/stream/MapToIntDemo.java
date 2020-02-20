package stream;

import java.util.Arrays;
import java.util.List;

public class MapToIntDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Geeks", "for", "gfg",
                "GeeksforGeeks", "GeeksQuiz");
        list.stream().mapToInt(str -> str.length()).forEach(System.out :: println);
    }
}

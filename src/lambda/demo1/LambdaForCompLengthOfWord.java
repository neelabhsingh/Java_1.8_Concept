package lambda.demo1;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaForCompLengthOfWord {
    public static void main(String[] args) {
        String [] words = {"Bye", "Hi", "Adios", "Halo", "Aloha"};
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        });
        for(String word: words){
            System.out.println(word);
        }

        System.out.println("Sort String using Lambda.");
        String [] newWords = {"Bye", "Hi", "Adios", "Halo", "Aloha"};
        Arrays.sort(newWords, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        Arrays.stream(newWords).forEach( word -> System.out.println(word));
    }
}

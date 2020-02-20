package java_basics.collections.operations;

import java.util.Arrays;
import java.util.List;

public class ConvertArraysOfStringToArrayList {
    public static void main(String[] args) {
        String[] words = {"ace", "boom", "crew", "dog", "eon"};
        List wordList = Arrays.asList(words);
        System.out.println(wordList);
        Integer[] nums = {1,2,3,4};
        //Use Arrays utility class
        List numsList = Arrays.asList(nums);
        System.out.println(numsList);
    }
}

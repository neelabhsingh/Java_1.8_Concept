package test;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class WordsFromDigits
{

    // A Dynamic Programming based
// function to count decodings
    static int countDecodingDP(String inputStr) {
        if (inputStr.charAt(0) == '0') {
            return 0;
        }

        int[] count = new int[inputStr.length()];
        count[0] = 1;
        for (int i = 1; i < inputStr.length(); i++) {
            int n = inputStr.charAt(i) - '0';
            int pre = inputStr.charAt(i - 1) - '0';
            if (n >= 1 && n <= 9) {
                count[i] += count[i - 1];
            }

            if (pre != 0) {
                int twoDigit = Integer.parseInt(inputStr.substring(i - 1, i + 1));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    count[i] = (i != 1) ? (count[i] + count[i - 2]) : (count[i] + 1);
                }
            }
        }
        return count[count.length - 1];
    }

    // Driver Code
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String str = scanner.next();

            System.out.println("Count is " + countDecodingDP(str));
        }
    }

    static int countSpecialElements(List<List<Integer>> matrix) {

        int[][] array = new int[matrix.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[matrix.get(i).size()];
        }
        for(int i=0; i<matrix.size(); i++){
            for (int j = 0; j < matrix.get(i).size(); j++) {
                array[i][j] = matrix.get(i).get(j);
            }
        }
        return countPositional(array, array.length, array[0].length);
    }

    static int countPositional(int a[][], int m, int n) {
        int rowmax[] = new int[m];
        int rowmin[] = new int[m];
        int colmax[] = new int[n];
        int colmin[] = new int[n];
        for (int i = 0; i < m; i++) {
            int rminn = Integer.MAX_VALUE;
            int rmaxx = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (a[i][j] > rmaxx)
                    rmaxx = a[i][j];
                if (a[i][j] < rminn)
                    rminn = a[i][j];
            }
            rowmax[i] = rmaxx;
            rowmin[i] = rminn;
        }
        for (int j = 0; j < n; j++) {
            int cminn = Integer.MAX_VALUE;
            int cmaxx = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (a[i][j] > cmaxx)
                    cmaxx = a[i][j];
                if (a[i][j] < cminn)
                    cminn = a[i][j];
            }

            colmax[j] = cmaxx;
            colmin[j] = cminn;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((a[i][j] == rowmax[i])
                        || (a[i][j] == rowmin[i])
                        || (a[i][j] == colmax[j])
                        || (a[i][j] == colmin[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}

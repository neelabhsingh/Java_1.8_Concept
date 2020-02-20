package test.vedantu;


import java.io.*;
import java.util.*;
public class CharacterAtK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr = new String[n];
        for(int i_arr=0; i_arr<n; i_arr++)
        {
            arr[i_arr] = br.readLine();
        }
        int p = Integer.parseInt(br.readLine().trim());
        int m = 3;
        int[][] Q = new int[p][m];
        for(int i_Q=0; i_Q<p; i_Q++)
        {
            String[] arr_Q = br.readLine().split(" ");
            for(int j_Q=0; j_Q<arr_Q.length; j_Q++)
            {
                Q[i_Q][j_Q] = Integer.parseInt(arr_Q[j_Q]);
            }
        }

        char[] out_ = solve(Q, arr);
        for(int i_out_=0; i_out_<out_.length; i_out_++)
        {
            System.out.println(out_[i_out_]);
        }


        wr.close();
        br.close();
    }
    static char[] solve(int[][] Q, String[] arr){
        // Your code here
        int size = Q.length;
        char [] result = new char[size];
        for(int i=0; i < size; i++){
            int L = Q[i][0];
            int R = Q[i][1];
            int K = Q[i][2];
            StringBuilder sb = new StringBuilder();
            int index = L -1;
            while (index < R){
                sb.append(arr[index]);
                index++;
            }
            result[i] = sb.charAt(K-1);
        }
        return result;
    }
}
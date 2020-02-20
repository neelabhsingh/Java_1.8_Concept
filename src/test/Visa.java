package test;

import java.util.List;

public class Visa {
    public static void printAntiDiag(List<List<Integer>> matrix){
        int[][] array = new int[matrix.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[matrix.get(i).size()];
        }
        for(int i=0; i<matrix.size(); i++){
            for (int j = 0; j < matrix.get(i).size(); j++) {
                array[i][j] = matrix.get(i).get(j);
            }
        }

    }
    public int[] findDiagonalOrder(int[][] array) {
        if (array.length == 0)
            return new int[0];
        int m = array.length;
        int n = array[0].length;
        int [] result  = new int[m * n];
        int i = 0, j = n-1;
        for(int k = 0; k < m*n; k++){
            result[k] = array[i][j];
            if( (i + j) % 2 == 0){
                if     (j == n -1) {i++; }
                else if( i== 0)    {j++; }
                else           {i--;j++; }
            }else{
                if    ( i == m -1)  {j++; }
                else if(j ==0)      {i++; }
                else          { i++; j--; }
            }
        }
        return result;
    }
}

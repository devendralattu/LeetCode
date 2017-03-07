// https://leetcode.com/problems/spiral-matrix-ii/

public class Solution {
    public int[][] generateMatrix(int n) {
        
        if(n == 0) {
            return new int[0][];
        }    
        int matrix[][] = new int[n][n];
        int row_start = 0, row_end = n - 1;
        int col_start = 0, col_end = n - 1;
        int count = 1;
        
        while(row_start <= row_end && col_start <= col_end) {
            
            for(int i = col_start; i <= col_end; i++) {
                matrix[row_start][i] = count++;
            }
            row_start++;
            
            for(int i = row_start; i <= row_end; i++) {
                matrix[i][col_end] = count++;
            }
            col_end--;
            
            if(row_start <= row_end){
                for(int i = col_end; i >= col_start; i--) {
                    matrix[row_end][i] = count++;
                }
            }
            row_end--;
            
            if(col_start <= col_end){
                for(int i = row_end; i >= row_start; i--) {
                    matrix[i][col_start] = count++;
                }
            }
            col_start++;
            
        }
        
    return matrix;
    }
}

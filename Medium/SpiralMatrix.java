// https://leetcode.com/problems/spiral-matrix

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    
        List<Integer> list = new ArrayList<>();
        
        if(matrix == null || matrix.length == 0) {
            return list;
        }    
        
        int row_start = 0, row_end = matrix.length - 1;
        int col_start = 0, col_end = matrix[0].length - 1;
        
        while(row_start <= row_end && col_start <= col_end) {
            
            for(int i = col_start; i <= col_end; i++) {
                list.add(matrix[row_start][i]);
            }
            row_start++;
            
            for(int i = row_start; i <= row_end; i++) {
                list.add(matrix[i][col_end]);
            }
            col_end--;
            
            if(row_start <= row_end){
                for(int i = col_end; i >= col_start; i--) {
                    list.add(matrix[row_end][i]);
                }
            }
            row_end--;
            
            if(col_start <= col_end){
                for(int i = row_end; i >= row_start; i--) {
                    list.add(matrix[i][col_start]);
                }
            }
            col_start++;
            
        }
        
        return list;
    }
}

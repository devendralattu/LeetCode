/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/
class Solution {
    public void rotate(int[][] matrix) {
        
        // Reverse upside down
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            reverse(matrix, i);
        }
        
        /*
        1  2  3  4      13 14 15 16
        5  6  7  8   => 9  10 11 12
        9  10 11 12     5  6  7  8
        13 14 15 16     1  2  3  4
        */
        
        // symmerty swap along top left to bottom right diagonal
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                swap(matrix, i ,j);
            }    
        }
        
        /*
        13 14 15 16     13  9   5  1
        9  10 11 12  => 14  10  6  2
        5  6  7  8      15  11  7  3
        1  2  3  4      16  12  8  4
        */        
        
    }
    
    private void reverse(int[][] matrix, int i) {
        int n = matrix.length;
        
        for(int j = 0; j < n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n - 1 - i][j];
            matrix[n - 1 - i][j] = temp;
        }
    }
    
    private void swap(int[][] matrix, int p, int q) {
        int temp = matrix[p][q];
        matrix[p][q] = matrix[q][p];
        matrix[q][p] = temp;
    }
}

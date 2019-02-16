/*
    A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
*/

public boolean isToeplitzMatrix(int[][] matrix) {
    if (matrix.length == 1 || matrix[0].length == 1) {
        return true;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j ++) {
            if (matrix[i-1][j-1] != matrix[i][j]) {
                return false;
            }
        }
    }
    return true;
}

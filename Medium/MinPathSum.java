// https://leetcode.com/problems/minimum-path-sum/

public int minPathSum(int[][] grid) {
      int m = grid.length;
    	int n = grid[0].length;
    	
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    		    
    		    if (i == 0 && j == 0) {
    				//do nothing
    		    }
    			else if (i == 0 && j != 0) {
    			    // keep adding elements from first row 
    				grid[i][j] = grid[i][j] + grid[i][j - 1];
    			} else if (i != 0 && j == 0) {
    			    // keep adding elements from first column
    				grid[i][j] = grid[i][j] + grid[i - 1][j];
    			} else {
    			    // Select the min point from where we need to take the turn and add distance value from current location.
    				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
    			}
    			
    		}
    	}
    
    	return grid[m - 1][n - 1];
}

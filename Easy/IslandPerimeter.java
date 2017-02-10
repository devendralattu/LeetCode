/* https://leetcode.com/problems/island-perimeter/ */

public class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int count = 0;
        if(grid[0][0] == 1){
            count += 4;
        }
        
        for(int g = 1; g < grid[0].length; g++) {
            if(grid[0][g] == 1) {
                if(grid[0][g - 1] == 1){
                    count += 2;
                }
                else{
                    count += 4;
                }
            }    
        }
        
        for(int g = 1; g < grid.length; g++) {
            if(grid[g][0] == 1) {
                if(grid[g - 1][0] == 1){
                    count += 2;
                }
                else{
                    count += 4;
                }
            }    
        }
        
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                if(grid[i][j] != 1) {
                    continue;
                }
                    
                if(grid[i - 1][j] == 1 && grid[i][j - 1] == 1){
                    continue;
                }    
                if(grid[i - 1][j] == 0 && grid[i][j - 1] == 0){
                    count += 4;
                }
                else{
                    count += 2;
                }
            }    
        }
        
        return count;
    }
}

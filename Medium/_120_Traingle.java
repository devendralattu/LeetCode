/*
    Given a triangle, find the minimum path sum from top to bottom. 
    Each step you may move to adjacent numbers on the row below.
    For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
*/

// Dynamic Programming

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        int[] pathSum = new int[len + 1];
        
        for(int i = len - 1; i >= 0; i--) {
            List<Integer> layer = triangle.get(i);
            for(int j = 0; j < i + 1; j++) {
                pathSum[j] = Math.min(pathSum[j], pathSum[j + 1]) + layer.get(j);
            }
        }
        
        return pathSum[0];
    }
}

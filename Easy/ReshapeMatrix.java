// https://leetcode.com/problems/reshape-the-matrix/#/description
//  566. Reshape the Matrix 

public int[][] matrixReshape(int[][] nums, int r, int c) {
      if(nums == null || nums.length == 0 || (nums.length <= r && nums[0].length <= c)) {
          return nums;
      }

      int[][] result = new int[r][c];
      int rIndex = 0, cIndex = 0;

      for(int i = 0; i < nums.length; i++) {
          for(int j = 0; j < nums[i].length; j++) {
              if(cIndex == c) {
                  rIndex++;
                  cIndex = 0;
              }
              result[rIndex][cIndex++] = nums[i][j];
          }
      }

      return result;
}


// OR simpler way with ONE for loop


public int[][] matrixReshape(int[][] nums, int r, int c) {
      if(nums == null || nums.length == 0 || (nums.length * nums[0].length != r * c)) {
          return nums;
      }

      int nums_cols = nums[0].length;
      int[][] result = new int[r][c];

      for(int i = 0; i < r * c; i++) {
          result[i / c][i % c] = nums[i / nums_cols][i % nums_cols];
      }

      return result;
}

/* https://leetcode.com/problems/sum-of-left-leaves/ */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int sum = 0;
        if(root.left == null) {
            sum += sumOfLeftLeaves(root.right);
        }
        else {
            if(root.left.left == null && root.left.right == null){
                sum += root.left.val + sumOfLeftLeaves(root.right);
            } else {
                sum += sumOfLeftLeaves(root.left);
                sum += sumOfLeftLeaves(root.right);
            }    
        }
        
        return sum;
    }
}

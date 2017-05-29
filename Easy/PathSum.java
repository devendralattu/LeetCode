// 112. Path Sum 
// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. 
// https://leetcode.com/problems/path-sum/#/description

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        return hasPathSum(root, sum, 0);
    }
    
    public boolean hasPathSum(TreeNode root, int sum, int sumSoFar) {
        
        if(root == null) {
            return true;
        }
        
        sumSoFar += root.val;
        
        if(root.left == null &&  root.right == null) {
            return (sumSoFar == sum);
        }
        
        boolean leftCheck = false;
        if(root.left != null)
            leftCheck = hasPathSum(root.left, sum, sumSoFar);
        
        boolean rightCheck = false;
        if(root.right != null)
            rightCheck = hasPathSum(root.right, sum, sumSoFar);
            
        return leftCheck || rightCheck;
    }
}

/* https://leetcode.com/problems/balanced-binary-tree/ */

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
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int result = getHeight(root);
        return result != Integer.MIN_VALUE ? true : false; 
    }
    
    public static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if(leftHeight == Integer.MIN_VALUE || rightHeight == Integer.MIN_VALUE || Math.abs(leftHeight - rightHeight) > 1){
            return Integer.MIN_VALUE;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

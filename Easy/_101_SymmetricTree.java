/* 101. Symmetric Tree  */
/* https://leetcode.com/problems/symmetric-tree/#/description */

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null || rightNode == null) {
            return leftNode == rightNode;
        }
        
        if(leftNode.val != rightNode.val) {
            return false;
        }
        
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }
}

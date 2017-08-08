/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// RDL traversal

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        int[] store = new int[1];
        traversal(root, store);
        return root;
    }
    
    private void traversal(TreeNode root, int[] store) {
        if(root == null) {
            return;
        }
        traversal(root.right, store);
        
        root.val += store[0];
        store[0] = root.val;
        
        traversal(root.left, store);
    }
}

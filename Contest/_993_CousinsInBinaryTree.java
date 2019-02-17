/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode parentX = findParent(root, x);
        TreeNode parentY = findParent(root, y);
        return findDepth(root, x) == findDepth(root, y) && parentX != null && parentY != null && parentX.val != parentY.val;
    }
    public int findDepth(TreeNode root, int val) {
        return findDepth(root, val, 0);
    }
    public TreeNode findParent(TreeNode root, int val) {
        return findParent(root, val, null);
    }
    public TreeNode findParent(TreeNode root, int val, TreeNode parent) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return parent;
        }
        TreeNode parentFound = findParent(root.left, val, root);
        if(parentFound != null) {
            return parentFound;
        }
        parentFound = findParent(root.right, val, root);
        return parentFound;
    }
    public int findDepth(TreeNode root, int val, int level) {
        if (root == null) {
            return 0;
        }
        if (root.val == val) {
            return level;
        }
        int childLevel = findDepth(root.left, val, level + 1);
        if (childLevel != 0) {
           return childLevel; 
        }
        childLevel = findDepth(root.right, val, level + 1);
        return childLevel; 
    }
}

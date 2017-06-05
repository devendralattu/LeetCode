/*
    Example 1:
        Given tree s:
             3
            / \
           4   5
          / \
         1   2
        Given tree t:
           4 
          / \
         1   2
    Return true, because t has the same structure and node values with a subtree of s.

    Example 2:
        Given tree s:
             3
            / \
           4   5
          / \
         1   2
            /
           0
        Given tree t:
           4
          / \
         1   2
    Return false. 
*/


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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }        
        
        if(isMatch(s, t)) {
            return true;
        }
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isMatch(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null || s.val != t.val) {
            return false;
        }
        
        return isMatch(s.left, t.left) && isMatch(s.right, t.right);
    }
}

/*
    Input: Binary tree: [1,2,3,4]
           1
         /   \
        2     3
       /    
      4     
    Output: "1(2(4))(3)"
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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2str(root, sb);
        return sb.toString();
    }
    private void tree2str(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        sb.append(root.val);
        
        if(root.left != null || root.right != null) {
            sb.append("(");
            if(root.left != null) {
                tree2str(root.left, sb);    
            }
            sb.append(")");
            
            if(root.right != null) {
                sb.append("(");
                tree2str(root.right, sb);    
                sb.append(")");
            }
        }
    }
}

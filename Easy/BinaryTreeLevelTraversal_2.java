//107. Binary Tree Level Order Traversal II 
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description
//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        List<Integer> level = new ArrayList<Integer>();
        
        if(root == null) {
            return levelOrder;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            
            if(node == null && !queue.isEmpty()) {
                levelOrder.add(level);
                level = new ArrayList<Integer>();
                queue.add(null);
                continue;
            }
            
            if(node == null) {
                levelOrder.add(level);
                break;
            }
            
            level.add(node.val);
            
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        
        Collections.reverse(levelOrder);
        return levelOrder;
    }
}

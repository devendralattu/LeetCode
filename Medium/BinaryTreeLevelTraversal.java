// https://leetcode.com/problems/binary-tree-level-order-traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null){
            return list;
        }
        queue.add(root);
        queue.add(null);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null && !queue.isEmpty()){
                list.add(new ArrayList<Integer>(level));
                level = new ArrayList<Integer>();
                queue.add(null);
                continue;
            }
            
            if(node != null){
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                level.add(node.val);
            }
        }
        list.add(new ArrayList<Integer>(level));
        
        return list;
    }
}

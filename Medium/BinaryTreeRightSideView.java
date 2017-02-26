https://leetcode.com/problems/binary-tree-right-side-view

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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();
        list = getRightNodes(root, list, 0);
        return list;
    }
    
    public static List<Integer> getRightNodes(TreeNode root, List<Integer> list, int level){
        
        if(root == null) {
            return list;
        }
        
        if(list.size() == level){
            list.add(root.val);
        }
        
        level++;
        list = getRightNodes(root.right, list, level);
        list = getRightNodes(root.left, list, level);
        
        return list;
    }
}

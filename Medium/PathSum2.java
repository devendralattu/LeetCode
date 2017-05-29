// 113. Path Sum II 
// https://leetcode.com/problems/path-sum-ii/#/description
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 


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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathsList = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        if(root != null) {
            pathSum(root, sum, pathsList, list);
        }
        
        return pathsList;
    }
    
    public void pathSum(TreeNode root, int sum, List<List<Integer>> pathsList, List<Integer> list) {
        if(root == null) {
            return;
        }
        
        list.add(root.val);
        
        if(root.left == null && root.right == null && sum == root.val) {
            pathsList.add(new ArrayList<Integer>(list));
        }
        
        if(root.left != null) {
            pathSum(root.left, sum - root.val, pathsList, list);
        }
        
        if(root.right != null) {
            pathSum(root.right, sum - root.val, pathsList, list);
        }
        
        list.remove(list.size() - 1);
    }
}

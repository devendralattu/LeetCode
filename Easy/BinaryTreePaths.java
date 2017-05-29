// 257. Binary Tree Paths 
// Given a binary tree, return all root-to-leaf paths. 
// https://leetcode.com/problems/binary-tree-paths/#/description
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
    public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		if (root != null) {
			binaryTreePaths(root, list, root.val + "->");
		}
		return list;
	}

	public void binaryTreePaths(TreeNode root, List<String> list, String s) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			list.add(s.substring(0, s.length() - 2));
			return;
		}

		if(root.left != null)
		    binaryTreePaths(root.left, list, s + root.left.val + "->");
		if(root.right != null)    
		    binaryTreePaths(root.right, list, s + root.right.val + "->");
	}
}

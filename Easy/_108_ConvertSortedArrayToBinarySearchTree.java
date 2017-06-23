// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) {
            return null;
        }
        return toBST(nums, 0, nums.length - 1);
    }
    private TreeNode toBST(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, start, mid - 1);
        root.right = toBST(nums, mid + 1, end);
        
        return root;
    }
}

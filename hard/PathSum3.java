//  437. Path Sum III 
// https://leetcode.com/problems/path-sum-iii/#/description

/* You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go downwards 
(traveling only from parent nodes to child nodes).
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
    public int pathSum(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        return pathSum(root, k, 0, map);
    }
    
    public int pathSum(TreeNode root, int k, int sum, Map<Integer, Integer> map) {
        
        if(root == null) {
            return 0;
        }
        
        sum += root.val;
        int result = 0;
        
        if(map.containsKey(sum - k)) {
            result += map.get(sum - k);    
        }
        
        if(map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 1);
        }
        
        result += pathSum(root.left, k, sum, map);
        result += pathSum(root.right, k, sum, map);
        
        // decrement the counter of the child node after iterating
        map.put(sum, map.get(sum) - 1);
        
        return result;
    }
}

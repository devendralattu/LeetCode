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
    public static class LevelNode {
        int level;
        TreeNode levelNode;
        LevelNode (int level, TreeNode levelNode) {
            this.level = level;
            this.levelNode = levelNode;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        LevelNode node1 = getLevelNode(root, x, 0, null);
        LevelNode node2 = getLevelNode(root, y, 0, null);
        return node1 != null && node1.levelNode != null && node2 != null && node2.levelNode != null
            && node1.level == node2.level && node1.levelNode.val != node2.levelNode.val;
    }
    private static LevelNode getLevelNode(TreeNode root, int val, int level, TreeNode parent) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return new LevelNode(level, parent);
        }
        LevelNode levelNode = getLevelNode(root.left, val, level + 1, root);
        if(levelNode != null) {
            return levelNode;
        }
        return getLevelNode(root.right, val, level + 1, root);
    }
}

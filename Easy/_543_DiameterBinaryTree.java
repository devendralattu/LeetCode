// Brute force solution 
// call getHeight for each node: Time O(N^2) for linear tree or O(N lgN) for balanced tree
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        int dl = diameterOfBinaryTree(root.left);
        int dr = diameterOfBinaryTree(root.right);
        
        return Math.max(lh + rh, Math.max(dl, dr));
    }
    
    public static int getHeight(TreeNode root){
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}


// Optimized Solution : Time O(n)
public class Solution {
    
    private int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        getMaxDepth(root);
        return max;
    }
    
    private int getMaxDepth(TreeNode root){
        if(root == null) {
            return 0;
        }
        
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return 1 + Math.max(left, right);
    }
}

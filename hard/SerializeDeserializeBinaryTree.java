// https://leetcode.com/problems/serialize-and-deserialize-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        String space = " ";
        String nullChar = "N ";
        if(root == null) {
            return sb.toString();
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if(node == null) {
                sb.append(nullChar);
                continue;
            }
            sb.append(node.val + space);
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        
        String[] stream = data.split(" ");
        int len = stream.length;
        TreeNode root;
        try {
            root = new TreeNode(Integer.parseInt(stream[0]));
        } catch(Exception e) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        for(int i = 1; i < len; i = i + 2) {
            TreeNode parent = queue.poll();
            if(i < len && isInteger(stream[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(stream[i]));
                parent.left = left;
                queue.add(parent.left);
            }
            
            if(i + 1 < len && isInteger(stream[i + 1])) {
                TreeNode right = new TreeNode(Integer.parseInt(stream[i + 1]));
                parent.right = right;
                queue.add(parent.right);
            }
        }
        
        return root;
    }
    
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

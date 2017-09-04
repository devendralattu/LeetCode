/*

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

*/

public boolean isValidBST(TreeNode root) {
    if(root == null) {
        return true;
    }

    return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Long.MAX_VALUE);
}

private boolean isValidBST(TreeNode root, long low, long high) {
    if(root == null) {
        return true;
    }

    if(root.val <= low || root.val >= high) {
        return false;
    }

    return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
}

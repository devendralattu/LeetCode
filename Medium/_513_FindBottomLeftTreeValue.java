public int findBottomLeftValue(TreeNode root) {
    int[] element = new int[]{0, -1}; // {currentLevel, data}
    helper(root, element, 0);
    return element[1];
}

private void helper(TreeNode root, int[] element, int currentLevel) {
    if (root == null) {
        return;
    }

    if(currentLevel == element[0]) {
        element[0]++;
        element[1] = root.val;
    }

    helper(root.left, element, currentLevel + 1);
    helper(root.right, element, currentLevel + 1);
}

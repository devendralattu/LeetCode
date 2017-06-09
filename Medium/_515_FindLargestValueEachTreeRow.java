


public List<Integer> largestValues(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root != null) {
        getNodesPerHeight(root, list, 0);
    }
    return list;
}

private void getNodesPerHeight(TreeNode root, List<Integer> list, int d) {
    if(root == null) {
        return;    
    }

    if(d == list.size()) {
        list.add(root.val);
    } else {
        list.set(d, Math.max(root.val, list.get(d)));
    }

    getNodesPerHeight(root.left, list, d + 1);
    getNodesPerHeight(root.right, list, d + 1);
}

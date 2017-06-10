public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    traverse(root, list, 0);
    return list;
}
private void traverse(TreeNode root, List<List<Integer>> list, int level) {
    if(root == null) return;

    if(list.size() == level) {
        list.add(new LinkedList<>());
    }

    List<Integer> levelList = list.get(level);
    levelList.add(root.val);

    traverse(root.left, list, level + 1);
    traverse(root.right, list, level + 1);
}

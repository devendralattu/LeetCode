/*
For example:
  Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
      /  \
     15   7
Output:
    [
      [3],
      [20,9],
      [15,7]
    ]
*/

public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    traverse(root, list, 0); // current level is 0
    return list;
}

private void traverse(TreeNode root, List<List<Integer>> list, int level) {
    if(root == null) {
        return;
    }

    if(list.size() == level) {
        list.add(new LinkedList<>());
    }

    List<Integer> levelNodes = list.get(level);
    if((level & 1) == 0) {
        levelNodes.add(root.val);
    } else {
        levelNodes.add(0, root.val);
    }

    level++;
    traverse(root.left, list, level);
    traverse(root.right, list, level);
}

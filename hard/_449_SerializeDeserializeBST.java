package hard;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST {

	private static final String SPLIT = ",";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			return null;
		}
		buildString(root, sb);
		return sb.toString();
	}

	public void buildString(TreeNode node, StringBuilder sb) {
		sb.append(node.val).append(SPLIT);
		if (node.left != null) {
			buildString(node.left, sb);
		}
		if (node.right != null) {
			buildString(node.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		String[] strData = data.split(SPLIT);
		Queue<Integer> queue = new LinkedList<>();
		for (String s : strData) {
			queue.offer(Integer.parseInt(s));
		}
		return buildTree(queue);

	}

	private TreeNode buildTree(Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(queue.poll());
		Queue<Integer> smallerQueue = new LinkedList<>();

		while (!queue.isEmpty() && queue.peek() < root.val) {
			smallerQueue.offer(queue.poll());
		}

		root.left = buildTree(smallerQueue);
		root.right = buildTree(queue);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(12);

		SerializeDeserializeBST sd = new SerializeDeserializeBST();
		String serialized = sd.serialize(root);

		System.out.println(serialized);

		TreeNode deserialized = sd.deserialize(serialized);

		// check if the str match
		System.out.println(sd.serialize(deserialized));
	}
}

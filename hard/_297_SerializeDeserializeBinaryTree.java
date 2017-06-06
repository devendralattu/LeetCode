package hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class SerializeDeserializeTree {

	private static final String spliter = ",";
	private static final String NN = "X";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append(NN).append(spliter);
		} else {
			sb.append(node.val).append(spliter);
			buildString(node.left, sb);
			buildString(node.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(spliter)));
		return buildTree(nodes);
	}

	private TreeNode buildTree(Queue<String> nodes) {
		String val = nodes.remove();
		if (val.equals(NN))
			return null;
		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}

	public static void main(String[] args) {

		SerializeDeserializeTree sd = new SerializeDeserializeTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		String serialized = sd.serialize(root);
		System.out.println(serialized);

		TreeNode deserialized = sd.deserialize(serialized);
		System.out.println(deserialized);

		// check if the str match
		System.out.println(sd.serialize(deserialized));
	}
}

package easy;

import java.util.ArrayList;
import java.util.List;

class LL {
	Node head;
	int llCount;

	public LL() {
		head = new Node();
		llCount = 0;
	}

	public LL(int val) {
		head = new Node(val);
		llCount++;
	}

	public LL(Node head, int llCount) {
		this.head = head;
		this.llCount = llCount;
	}
}

class Node {
	Node next;
	int val;

	public Node(int val) {
		this.val = val;
	}

	public Node() {
		next = null;
		val = 0;
	}
}

public class PascalTriangle {

	public List<LL> generate(int numRows) {
		List<LL> result = new ArrayList<LL>();// LinkedList<>();
		LL llNode = new LL();

		for (int i = 0; i < numRows; i++) {

			addToHead(llNode, 1);
			Node current = llNode.head.next;
			
			// LL newllNode = new LL(llNode.head.next, llNode.llCount);

			for (int j = 1; j < llNode.llCount - 1; j++) {
				current.val = current.val + current.next.val;
				current = current.next;
			}

			printNodes(llNode.head);
		}
		result.add(llNode);
		return result;
	}

	private void addToHead(LL llNode, int data) {

		Node head = llNode.head;
		Node one = new Node(data);
		one.next = head;
		llNode.head = one;
		llNode.llCount++;		
	}

	private void printNodes(Node current) {
		while (current.next != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		List<LL> result = pt.generate(5);

		for (LL l : result) {
			System.out.println("\nllCount #" + l.llCount);
			Node current = l.head;
			while (current.next != null) {
				System.out.print(current.val + " -> ");
				current = current.next;
			}
			System.out.println();
		}
	}
}

/*
1 -> 
1 -> 1 -> 
1 -> 2 -> 1 -> 
1 -> 3 -> 3 -> 1 -> 
1 -> 4 -> 6 -> 4 -> 1 -> 

llCount #5
1 -> 4 -> 6 -> 4 -> 1 -> 
*/

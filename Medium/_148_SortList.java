/*
	Sort a linked list in O(n log n) time using constant space complexity.
*/

public class _148_SortList {

	private ListNode head;

	public _148_SortList(int data) {
		head = new ListNode(data);
	}

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int data) {
			val = data;
		}
	}

	public void append(int data) {
		ListNode end = new ListNode(data);
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = end;
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// break in two halves
		ListNode prev = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// sort each half
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		// merge both the halves
		return merge(l1, l2);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0);
		ListNode temp = l;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;
			} else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}

		if (l1 != null) {
			temp.next = l1;
		}
		if (l2 != null) {
			temp.next = l2;
		}

		return l.next;
	}

	public void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + "->");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		_148_SortList sl = new _148_SortList(10);
		sl.append(5);
		sl.append(2);
		sl.append(7);
		sl.append(4);
		sl.append(9);
		sl.append(12);
		sl.append(1);
		sl.append(8);
		sl.append(6);
		sl.append(11);
		sl.append(3);

		sl.printList(sl.head);
		sl.head = sl.sortList(sl.head);
		sl.printList(sl.head);
	}
}


/*
OUTPUT:
10->5->2->7->4->9->12->1->8->6->11->3->
1->2->3->4->5->6->7->8->9->10->11->12->
*/

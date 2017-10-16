/*
  Given a sorted linked list, delete all nodes that have duplicate numbers, 
  leaving only distinct numbers from the original list.

  For example,
  Given 1->2->3->3->4->4->5, return 1->2->5.
  Given 1->1->1->2->3, return 2->3. 
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        /* Iterative solution */
        /*
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode first = newHead;
        ListNode current = head;
        
        while(current != null) {
            while(current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if(first.next == current) {
                first = first.next;
            } else {
                first.next = current.next;
            }
            current = current.next;
        }
        
        return newHead.next;
        */
        
        /* Recursive solution */
        if(head.next != null && head.val == head.next.val) {
            while(head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}

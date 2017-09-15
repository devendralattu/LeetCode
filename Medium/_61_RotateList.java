/*
    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        int len = 0;
        while(curr.next != null) {
            curr = curr.next;
            len++;
        }
        
        k = k % len;
        if(k == 0) {
            return head;
        }
        
        ListNode prev = dummy;
        for(int i = 0; i < len - k; i++) {
            prev = prev.next;
        }
        
        curr.next = dummy.next;
        dummy.next = prev.next;
        prev.next = null;
        
        head = dummy.next;
        return head;
    }
}

/*
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    You must do this in-place without altering the nodes' values.
    Given {1,2,3,4}, reorder it to {1,4,2,3}. 
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 1->2->3->4->5->6      OR       1->2->3->4->5
        
        int count = 0, i = 0;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        
        // count = 2
        // 1->2->3->4->5->6      OR       1->2->3->4->5
        //       s     f                        s     f
        
        slow.next = reverseList(slow.next);
        // 1->2->3->6->5->4      OR       1->2->3->5->4
        //       s                              s
        
        fast = head;
        slow = slow.next;
        // 1->2->3->6->5->4      OR       1->2->3->5->4
        // f        s                     f        s
        
        while(i++ < count) {
            ListNode p1 = fast.next;
            ListNode p2 = slow.next;
            fast.next = slow;
            slow.next = p1;
            fast = p1;
            slow = p2;
        }
        
        // 1->6->2->5->3->6 & 4->null & slow = 4     OR       1->5->2->4->3->5 & slow = p2 = null
        //             f                                                  f
        
        fast.next = slow; // 3->4 OR 3->null
        if(slow != null) {
            slow.next = null;
        }
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode h2 = null;
        ListNode current = head;
        
        while(head != null) {
            head = current.next;
            current.next = h2;
            h2 = current;
            current = head;
        }
        
        return h2;
    }
}

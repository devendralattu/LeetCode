// https://leetcode.com/problems/palindrome-linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null){
            return true;
        }
        int slowCount = 0;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            slowCount++;
        }
        
        //check for odd length linked list
        if(fast != null) {
            slow = slow.next;
        }
        
        // reverse list starting from slow pointer
        ListNode previous = null;
	    while (slow != null) {
	        ListNode current = slow.next;
	        slow.next = previous;
	        previous = slow;
	        slow = current;
	    }
        
        for(int i = 0; i < slowCount; i++){
            if(head.val != previous.val){
                return false;
            }
	        head = head.next;
			previous = previous.next;
        }
        
        return true;
    }
}

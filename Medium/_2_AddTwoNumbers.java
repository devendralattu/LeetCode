/** 
https://leetcode.com/problems/add-two-numbers/ 
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
**/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) { 
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while(l1 != null || l2 != null) {
            int sum = ((l1 != null) ? l1.val : 0) + 
                ((l2 != null) ? l2.val : 0) +
                carry;
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return result.next;
    }
}

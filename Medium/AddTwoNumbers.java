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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            l1 = l1.next;
            l2 = l2.next;
            
            ListNode l_temp = new ListNode(sum);
            l3.next = l_temp;
            l3 = l3.next;
        }
        //only one of the below two while loops will get executed
        while(l1 != null){
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            l1 = l1.next;
            
            ListNode l_temp = new ListNode(sum);
            l3.next = l_temp;
            l3 = l3.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            l2 = l2.next;
            
            ListNode l_temp = new ListNode(sum);
            l3.next = l_temp;
            l3 = l3.next;
        }
        
        // if there is still a carry left then add it to list
        if(carry > 0){
            ListNode l_temp = new ListNode(carry);
            l3.next = l_temp;
            l3 = l3.next;
        }
        
        return head.next;
    }
}

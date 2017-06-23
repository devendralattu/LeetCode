/*
    Given a linked list, swap every two adjacent nodes and return its head.
    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3. 
*/

public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) {
        return head;
    }

    ListNode temp = head.next;
    head.next = swapPairs(head.next.next);
    temp.next = head;

    return temp;
}

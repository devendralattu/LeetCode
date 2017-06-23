/*
  Example:
    Given 1->2->3->4->5->NULL,
    return 1->3->5->2->4->NULL. 
*/

public ListNode oddEvenList(ListNode head) {
    if(head == null) {
        return head;
    }
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;

    while(even != null && even.next != null) {
        odd.next = odd.next.next;
        even.next = even.next.next;

        odd = odd.next;
        even = even.next;
    }

    odd.next = evenHead;
    return head;
}

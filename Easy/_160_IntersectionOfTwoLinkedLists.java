/*
For example, the following two linked lists:
    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗            
    B:     b1 → b2 → b3
begin to intersect at node c1.
*/


public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    ListNode tempA = headA;
    int countA = 0;
    while(tempA != null) {
        countA++;
        tempA = tempA.next;
    }

    ListNode tempB = headB;
    int countB = 0;
    while(tempB != null) {
        countB++;
        tempB = tempB.next;
    }

    tempA = headA;
    tempB = headB;
    int diff = Math.abs(countA - countB);
    if(countA > countB) {
        while(diff-- > 0) {
            tempA = tempA.next;
        }
    } else {
        while(diff-- > 0) {
            tempB = tempB.next;
        }
    }

    while(tempA != null && tempB != null && tempA != tempB) {
        tempA = tempA.next;
        tempB = tempB.next;
    }
    return tempA;
}

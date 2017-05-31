// 382. Linked List Random Node 
// https://leetcode.com/problems/linked-list-random-node/#/description
// Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

/*
Method 1: Time Complexity for getRandom() is O(N) & Space Complexity O(1)
Overall time complexity is still O(N).

I am calculating the value k which is the length of the LinkedList. Then, I generate a random number within the range k and simply traversing the list till that random number and return the value of the traversed node.
*/

int k;
ListNode head;
public Solution(ListNode head) {
    k = 0;
    this.head = head;
    while(head != null) {
        k++;
        head = head.next;
    }
}

/** Returns a random node's value. */
public int getRandom() {
    int rand = (int)(Math.random() * k);
    ListNode node = head;
    int result = node.val;
    
    while(node != null && rand != 0) {
        rand--;
        node = node.next;
    }
    return node != null ? node.val : result;
}

/*
Method 2: Time Complexity for getRandom() is O(1) & Space Complexity O(N)
Overall time complexity is still O(N).
Instead of traversing the list at getRandom() as we saw in Method 1, we can simply add the values from LinkedList to a separate array or ArrayList.
Then, generate a random number equivalent to the list size and retrieve the element from the list at the position of random number.
*/

ListNode head;
List<Integer> list;
public Solution(ListNode head) {
    list = new ArrayList<>();
    this.head = head;
    
    while(head != null) {
        list.add(head.val);
        head = head.next;
    }
}

/** Returns a random node's value. */
public int getRandom() {
    int rand = (int)(Math.random() * list.size());
    return list.get(rand);
}

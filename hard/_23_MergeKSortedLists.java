/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// ======== Solution 1: Time Complexity : O(NK) =========
/*
public ListNode mergeKLists(ListNode[] lists) {

    int k = lists.length;
    Set<Integer> kSet = new HashSet<>();
    ListNode result = new ListNode(0);
    ListNode curr = result;

    // prepare the empty list set
    for(int i = 0; i < k; i++) {
        if (lists[i] == null) {
            kSet.add(i);
        }
    }

    while(kSet.size() != k) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < k; i++) {
            if (kSet.contains(i)) {
                continue;
            }
            if(lists[i].val < min) {
                min = lists[i].val;
                minIndex = i;
            }
        }
        curr.next = new ListNode(min);
        curr = curr.next;
        lists[minIndex] = lists[minIndex].next;
        if(lists[minIndex] == null) {
            kSet.add(minIndex);
        }
    }
    return result.next;
}
*/
// Time complexity O(NK)
// K comparisions for a max list of size N

// ============= Solution 2: Time Complexity O(N lgK) ===============

public ListNode mergeKLists(ListNode[] lists) {

    ListNode result = new ListNode(0);
    ListNode curr = result;

    Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
        @Override
        public int compare(ListNode a, ListNode b) {
            return (a.val < b.val) ? -1 : ((a.val > b.val) ? 1 : 0);
        }
    });

    // Add the first k nodes to queue
    queue.addAll(Arrays.stream(lists).filter(listNode -> listNode != null).collect(Collectors.toList()));

    //for(ListNode listNode : lists) // in other words
    //    if(listNode != null) queue.add(listNode);

    // push all the elements from queue to the "curr" node
    // push subsequent .next elements from lists to queue
    while(!queue.isEmpty()) {
        curr.next = queue.poll();
        curr = curr.next;

        if(curr.next != null) {
            queue.add(curr.next);
        }
    }
    return result.next;
}

// In this optimized approach, we are making use of priority queue.
// Priority queue is having a space of K nodes. Thus every insert/poll operation will take O(lg K) time
// We will not loop over the same elements again to find the min like we did for the previous solution.
// Therefore, total time complexity to add and fetch N elements with lg K time is O(N lg K)

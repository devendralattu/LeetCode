/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
}

// Time complexity O(NK)
// K comparisions for a max list of size N

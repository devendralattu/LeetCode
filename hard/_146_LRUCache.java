// https://leetcode.com/problems/lru-cache/#/description
// 146. LRU Cache 

class DLL {
    int key;
    int value;
    DLL prev;
    DLL next;
}

public class LRUCache {

    private Map<Integer, DLL> cache;
    private int count, capacity;
    private DLL head, tail;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        
        count = 0;
        this.capacity = capacity;
        
        head = new DLL();
        tail = new DLL();
        
        head.prev = null;
        head.next = tail;
        
        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        DLL dllNode = cache.get(key);
        moveToHead(dllNode);
        
        return dllNode.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            DLL dllNode = cache.get(key);
            dllNode.value = value;
            moveToHead(dllNode);
            return;
        }
        
        // too add an element which is not in cache map
        DLL dllNode = new DLL();
        dllNode.key = key;
        dllNode.value = value;
        
        // add to map
        cache.put(key, dllNode);
        // add to DLL
        addToHead(dllNode);
        
        count++;
        
        if(count > capacity) {
            DLL tailNode = tail.prev;
            // remove from DLL
            removeNode(tailNode);
            // remove from cache map
            cache.remove(tailNode.key);
            
            count--;
        }
    }
    
    private void moveToHead(DLL dllNode) {
        removeNode(dllNode);
        addToHead(dllNode);
    }
    
    private void removeNode(DLL dllNode) {
        DLL before = dllNode.prev;
        DLL after = dllNode.next;
        
        before.next = after;
        after.prev = before;
    }
    
    private void addToHead(DLL dllNode) {
        dllNode.prev = head;
        dllNode.next = head.next;
        
        head.next.prev = dllNode;
        head.next = dllNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

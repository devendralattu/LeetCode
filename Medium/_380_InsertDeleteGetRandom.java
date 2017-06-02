/** https://leetcode.com/problems/insert-delete-getrandom-o1 **/

public class RandomizedSet {

    private static Map<Integer, Integer> map;
    private static List<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        
        int loc = map.get(val);
        int listSize = list.size();
        if(loc < listSize - 1){
            int lastVal = list.get(listSize - 1);
            map.put(lastVal, loc);
            list.set(loc, lastVal);
        }
        map.remove(val);
        list.remove(listSize - 1);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int range = list.size();
        
        int rand = (int)(Math.random() * range);
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

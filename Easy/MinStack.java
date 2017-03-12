// https://leetcode.com/problems/min-stack

public class MinStack {

    private static List<Integer> list;
    private static List<Integer> minVal;
    
    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
        minVal = new LinkedList<>();
    }
    
    public void push(int x) {
        list.add(x);
        if(!minVal.isEmpty()) {
            minVal.add(Math.min(minVal.get(minVal.size() - 1), x));
        } else {
            minVal.add(x);
        }
    }
    
    public void pop() {
        if(!list.isEmpty()) {
            list.remove(list.size() - 1);
            minVal.remove(minVal.size() - 1);
        }
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return minVal.get(minVal.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

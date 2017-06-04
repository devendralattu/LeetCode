/*
    Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
    So the median is the mean of the two middle value.
    Examples:
    [2,3,4] , the median is 3
    [2,3], the median is (2 + 3) / 2 = 2.5 
*/

private Queue<Integer> asc, desc;

/** initialize your data structure here. */
public MedianFinder() {
    // maintains natural ordering of elements
    asc = new PriorityQueue();
    // maintains reverse ordering of elements
    desc = new PriorityQueue(1000, Collections.reverseOrder());
}

public void addNum(int num) {
    asc.add(num);
    desc.add(asc.poll());

    if(asc.size() < desc.size()) {
        asc.add(desc.poll());
    }
}

public double findMedian() {
    return (asc.size() == desc.size()) ? (asc.peek() + desc.peek()) / 2.0 : asc.peek();
}

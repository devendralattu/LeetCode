/*
https://leetcode.com/problems/insert-interval

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> list = new ArrayList<>();
        
        for(Interval interval : intervals) {
            if(newInterval.start > interval.end || newInterval.end < interval.start) {
                list.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        
        int index = 0;
        for(Interval interval : list) {
            if(newInterval.start > interval.end) {
                index++;
            } else {
                break;
            }
        }
        list.add(index, newInterval);
        return list;
    }
}

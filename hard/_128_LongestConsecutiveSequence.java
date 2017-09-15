/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
*/

public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    int count = 0;
    if(nums == null) {
        return count;
    }

    for(int n : nums) {
        if(!map.containsKey(n)) {

            int prev = map.getOrDefault(n - 1, 0);
            int next = map.getOrDefault(n + 1, 0);

            int sum = prev + next + 1;
            count = Math.max(count, sum);

            map.put(n, sum);

            map.put(n - prev, sum);
            map.put(n + next, sum);
        }
    }

    return count;
}

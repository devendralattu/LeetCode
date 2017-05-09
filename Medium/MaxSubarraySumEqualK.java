/* 325: Maximum Size Subarray Sum Equals k */
//Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

public int maxLengthSubarray(int[] arr, int k) {

    int sum = 0;
    int max = 0;
    int count = -1;

    Map<Integer, Integer> map = new HashMap<>();

    for (int n : arr) {
        count++;

        sum += n;
        if (sum == k) {
            max = count + 1;
        }
        
        // indicates there are elements from map.get(sum - k) to current element having the required sum as `k`
        if (map.containsKey(sum - k)) {
            max = Math.max(max, count - map.get(sum - k));
            
            // Discard elements from index 0 to map.get(sum - k)
            // Consider from map.get(sum - k) to current index as they make up to the sum k
        }
        
        // At each iteration add sum obtained to map
        if (!map.containsKey(sum)) {
            map.put(sum, count);
        }
    }
    return max;
}

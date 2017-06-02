/*
    A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].
    Sets S[K] for 0 <= K < N are defined as follows:
    S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
    Sets S[K] are finite for each K and should NOT contain duplicates.
    Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.

    Input: A = [5,4,0,3,1,6,2]
    Output: 4
    Explanation: 
    A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

    One of the longest S[K]:
    S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
*/

public int arrayNesting(int[] nums) {
    int max = 0;
    if(nums == null || nums.length == 0) {
        return max;
    }

    boolean[] visited = new boolean[nums.length];
    for(int i = 0; i < nums.length; i++) {
        if(!visited[i]) {
            int count = getConnectedCount(nums, i, visited);
            max = Math.max(max, count);
        }
    }
    return max;
}
private int getConnectedCount(int[] nums, int start, boolean[] visited) {
    int count = 0;
    int i = start;
    while(i!= start || count == 0) {
        count++;
        visited[i] = true;
        i = nums[i];
    }

    return count;
}

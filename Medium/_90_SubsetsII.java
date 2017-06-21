/*
    If nums = [1,2,2], a solution is:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
*/

public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums != null) {
        Arrays.sort(nums);
        backtracking(result, new ArrayList<Integer>(), nums, 0);
    }
    return result;
}
private void backtracking(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
    result.add(new ArrayList<>(list));

    for(int i = start; i < nums.length; i++) {
        if(i > start && nums[i] == nums[i-1]) {
            continue;
        }    

        list.add(nums[i]);
        backtracking(result, list, nums, i + 1);
        list.remove(list.size() - 1);    

    }
}

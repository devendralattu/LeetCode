/*
    If nums = [1,2,3], a solution is:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
*/

public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
    if(nums != null) {
        backtracking(result, new ArrayList<Integer>(), nums, 0);
    }
    return result;
}

private void backtracking(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
    result.add(new ArrayList<>(list));

    for(int i = start; i < nums.length; i++) {
        list.add(nums[i]);
        backtracking(result, list, nums, i + 1);
        list.remove(list.size() - 1);
    }
}

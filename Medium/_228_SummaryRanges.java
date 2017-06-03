/*
    Given a sorted integer array without duplicates, return the summary of its ranges.
    For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]. 
*/

public List<String> summaryRanges(int[] nums) {
    List<String> list = new ArrayList<>();

    if(nums == null || nums.length == 0) {
        return list;
    }

    for(int i = 0; i < nums.length; i++) {
        int start = i;
        while(i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
            i++;
        }

        if(start == i) {
            list.add(Integer.toString(nums[start]));
        } else {
            list.add(nums[start] + "->" + nums[i]);
        }
    }

    return list;
}

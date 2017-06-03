/*
    Find all possible combinations of k numbers that add up to a number n, 
    given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
    
    Example 1: Input: k = 3, n = 7
    Output: [[1,2,4]]
    Example 2: Input: k = 3, n = 9
    Output: [[1,2,6], [1,3,5], [2,3,4]]
*/
public List<List<Integer>> combinationSum3(int k, int n) {

    List<List<Integer>> result = new ArrayList<>();
    combination(result, new ArrayList<Integer>(), k, n, 1);
    return result;
}

private void combination(List<List<Integer>>result, List<Integer> list, int k, int n, int start) {
    if(k == list.size() && n == 0) {
        result.add(new ArrayList<>(list));
        return;
    }

    if(k == list.size()) {
        return;
    }

    for(int i = start; i < 10; i++) {
        list.add(i);
        combination(result, list, k, n - i, i + 1);
        list.remove(list.size() - 1);
    }
}

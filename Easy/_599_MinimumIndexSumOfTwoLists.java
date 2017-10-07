/*
    Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

    You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

    Example 1:

    Input:
    ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
    Output: ["Shogun"]
    Explanation: The only restaurant they both like is "Shogun".

    Example 2:

    Input:
    ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    ["KFC", "Shogun", "Burger King"]
    Output: ["Shogun"]
    Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
*/

public String[] findRestaurant(String[] list1, String[] list2) {

    Map<String, Integer> map = new HashMap<>();

    int min = Integer.MAX_VALUE;
    List<String> result = new ArrayList<>();
    int idx = -1;

    for(String s : list1) {
        map.put(s, ++idx);    
    }

    idx = -1;
    for(String s : list2) {
        idx++;
        if(map.containsKey(s)) {
            int diff = map.get(s) + idx;
            if(diff < min) {
                min = diff;
                result = new ArrayList<>();
                result.add(s);
            } else if(diff == min) {
                result.add(s);
            }
        }    
    }

    String[] arr = result.toArray(new String[result.size()]);
    return arr;
}

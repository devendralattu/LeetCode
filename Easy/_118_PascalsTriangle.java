public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(numRows <= 0) return result;
        
        int i = 0;
        List<Integer> level = new ArrayList<>();
        
        while(i++ < numRows) {
            
            level.add(0, 1);
            int j = 0;
            
            while(++j < level.size() - 1) {
                level.set(j, level.get(j) + level.get(j + 1));
            }
            
            result.add(new ArrayList<>(level));
        }
        
        return result;
    }
}

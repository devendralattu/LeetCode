/*
[1,0,0]
[1,0,0]
[1,9,1]

You should travel from left top to the number 9 in the shortest way alongside the numbers 1
*/

// WIP
  public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,0,0));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,0,0));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(1,9,1));
        List<List<Integer>> lot = new ArrayList<>(Arrays.asList(l1, l2, l3));

        boolean flag = true;
        for (int i = 0; i < lot.size() && flag; i++) {
            for (int j = 0; j < lot.get(0).size() && flag; j++) {
                if (lot.get(i).get(j) == 9) {
                    dfs(lot, i, j, Integer.MIN_VALUE);
                    System.out.println("tadaa =>" + (lot.get(0).get(0) - Integer.MIN_VALUE));
                    flag = false;
                }
            }
        }
    }

    private static void dfs(List<List<Integer>> lot, int i, int j, int d) {
        if(i < 0 || i >= lot.size() || j < 0 || j >= lot.get(0).size() ||
                lot.get(i).get(j) == 0 || (lot.get(i).get(j) < d && lot.get(i).get(j) != 0)) {
            return;
        }
        lot.get(i).set(j, d);
        d++;
        dfs(lot, i + 1, j, d);
        dfs(lot, i - 1, j, d);
        dfs(lot, i, j + 1, d);
        dfs(lot, i, j - 1, d);
    }

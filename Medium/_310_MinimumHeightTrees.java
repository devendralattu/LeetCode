/*
Example 1:
  Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
            0
            |
            1
           / \
          2   3
  return [1]
Example 2:
  Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
         0  1  2
          \ | /
            3
            |
            4
            |
            5
  return [3, 4] 
*/

public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> leaves = new ArrayList<>();
    if(n <= 1) {
        leaves.add(0);
        return leaves;
    }

    List<Set<Integer>> adjacencyList = new ArrayList<>();
    for(int i = 0; i < n; i++) {
        adjacencyList.add(new HashSet<>());
    }
    for(int[] edge : edges) {
        adjacencyList.get(edge[0]).add(edge[1]);
        adjacencyList.get(edge[1]).add(edge[0]);
    }

    int node = 0;
    for(Set<Integer> set : adjacencyList) {
        if(set.size() == 1) {
            leaves.add(node);
        }
        node++;
    }

    while(n > 2) {
        n -= leaves.size();

        List<Integer> innerLeaves = new ArrayList<>();
        for(int i : leaves) {
            int j = adjacencyList.get(i).iterator().next();
            adjacencyList.get(j).remove(i);

            if(adjacencyList.get(j).size() == 1) {
                innerLeaves.add(j);
            }
        }
        leaves = innerLeaves;
    }
    return leaves;
}

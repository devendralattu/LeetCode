private static final int MAX = Integer.MAX_VALUE;

public int[][] updateMatrix(int[][] matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return matrix;
    }

    Queue<int[]> queue = new LinkedList<>();

    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] == 0) {
                queue.offer(new int[]{i, j});
            } else {
                matrix[i][j] = MAX;
            }
        }
    }

    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while(!queue.isEmpty()) {
        int[] data = queue.poll();
        int x = data[0], y = data[1];

        for(int[] d : dir) {
            int i = x + d[0];
            int j = y + d[1];

            if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= matrix[x][y] + 1) {
                continue;
            }
            matrix[i][j] = matrix[x][y] + 1;
            queue.offer(new int[]{i, j});
        }
    }

    return matrix;
}

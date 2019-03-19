/*
https://www.youtube.com/watch?v=cJayBq38VYw
https://leetcode.com/problems/trapping-rain-water-ii/discuss/89472/Visualization-No-Code

Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, 
compute the volume of water it is able to trap after raining.

https://leetcode.com/problems/trapping-rain-water-ii/
*/

class Solution {
    
    public static class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        Queue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.height - o2.height;
            }
        });

        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];

        // add border elemets to the queue
        for (int i = 0; i < n; i++) {
            queue.add(new Cell(i, 0, heightMap[i][0]));
            queue.add(new Cell(i, m - 1, heightMap[i][m - 1]));

            visited[i][0] = visited[i][m - 1] = true;
        }

        for (int i = 0; i < m; i++) {
            queue.add(new Cell(0, i, heightMap[0][i]));
            queue.add(new Cell(n - 1, i, heightMap[n - 1][i]));

            visited[0][i] = visited[n - 1][i] = true;
        }

        // Visit adjacent unvisited nodes
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxHeight = Integer.MIN_VALUE, waterLevel = 0;
        
        //// Method 1: update the max on ppping elements form the queue
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            // calculate max only for popped cells
            maxHeight = Math.max(maxHeight, cell.height);

            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];

                if (row >= 0 && row < n && col >= 0 && col < m && !visited[row][col]) {
                    visited[row][col] = true;
                    waterLevel += Math.max(0, maxHeight - heightMap[row][col]);
                    queue.add(new Cell(row, col, heightMap[row][col]));
                }
            }
        }

        return waterLevel;
    }
}

/// Method 2: insert the max adjacent element during add elements to the queue
/*
    while (!queue.isEmpty()) {
        Cell cell = queue.poll();
        for (int[] dir : dirs) {
            int row = cell.row + dir[0];
            int col = cell.col + dir[1];
            if (row >= 0 && row < n && col >= 0 && col < m && !visited[row][col]) {
                visited[row][col] = true;
                waterLevel += Math.max(0, cell.height - heightMap[row][col]);
                queue.offer(new Cell(row, col, 
                                     Math.max(heightMap[row][col], cell.height)));
            }
        }
    }
*/

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // 1) Add all treasure cells to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 2) BFS from all treasures at once
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Skip out of bounds
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                // Only process unvisited land cells (INF)
                if (grid[nr][nc] != 2147483647) {
                    continue;
                }

                // Distance is current cell + 1
                grid[nr][nc] = grid[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}

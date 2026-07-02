class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dist[][] = new int[m][n];

        for(int i = 0; i < m; i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
        Deque<int[]> deq = new ArrayDeque<>();
        deq.addFirst(new int[]{0, 0});

        dist[0][0] = 0;
        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        while(!deq.isEmpty()){

            int[] cur = deq.pollFirst();

            int r = cur[0];
            int c = cur[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int newCost = dist[r][c] + grid[nr][nc];

                if (newCost < dist[nr][nc]) {

                    dist[nr][nc] = newCost;

                    if (grid[nr][nc] == 0) {
                        deq.addFirst(new int[]{nr, nc});
                    } else {
                        deq.addLast(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
        }
}
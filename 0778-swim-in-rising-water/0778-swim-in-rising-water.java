class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        int res[][] = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{grid[0][0], 0, 0});
        res[0][0] = grid[0][0];

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int time = cur[0];
            int x = cur[1];
            int y = cur[2];

            if(x == n - 1 && y == n - 1) return time;
            
            if (time > res[x][y])
                continue;

            for(int[] dir : directions){
                int newx = dir[0] + x;
                int newy = dir[1] + y;

                if (newx >= 0 && newx < n && newy >= 0 && newy < n) {

                    int newTime = Math.max(time, grid[newx][newy]);

                    if (newTime < res[newx][newy]) {

                        res[newx][newy] = newTime;

                        pq.offer(new int[]{newTime, newx, newy});
                    }                
            }
        }
        
    }
    return res[n-1][n-1];
    }
}
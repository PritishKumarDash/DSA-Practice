class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] directions = {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
        };

        int row = heights.length;
        int col = heights[0].length;

        int res[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, 0, 0});
        res[0][0] = 0;

        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int diff = cur[0];
            int x = cur[1];
            int y = cur[2];

            if(x == row - 1 && y == col - 1) return diff;

            if(diff > res[x][y]) continue;
            
            for(int[] dir : directions){
                int newx = x + dir[0];
                int newy = y + dir[1];

                if(newx >= 0 && newx < row && newy >= 0 && newy < col ){
                    int abs = Math.abs(heights[x][y] - heights[newx][newy]);

                    int max = Math.max(diff, abs);

                    if(res[newx][newy] > max){
                        res[newx][newy] = max;
                        pq.offer(new int[]{max, newx, newy});
                    }
                }
            }
        }
        return res[row-1][col-1];
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        Queue<int[]> que = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) que.offer(new int[]{i, j});
            }
        }
        if(fresh == 0) return 0;
        int[][] direction = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int time = 0;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                int cur[] = que.poll();
                int r = cur[0];
                int c = cur[1];

                for(int[] dir : direction){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 0 || grid[nr][nc] == 2) continue;

                    que.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    fresh--;
                    if(fresh == 0){
                        return time + 1;
                    }
                }
            }
            time++;
        }
        return (fresh == 0)?time:-1;
    }
}
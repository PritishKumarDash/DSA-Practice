class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }

         Queue<int[]> que = new LinkedList<>();
         que.add(new int[]{0, 0});
         grid[0][0] = 1;
         int direction[][] = {
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,-1},
            {0,1},
            {1,-1},
            {1,0},
            {1,1}
         };

         int dist = 1;
         while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int cur[] = que.poll();
                int r = cur[0];
                int c = cur[1];

                if(r == grid.length - 1 && c == grid[0].length - 1){
                        return dist;
                }

                for(int dir[] : direction){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) continue;

                    if(grid[nr][nc] == 1) continue;

                    
                    grid[nr][nc] = 1;
                    que.add(new int[]{nr, nc});
                }
            }
            dist++;
         }
         return -1;
    }
}
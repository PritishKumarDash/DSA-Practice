class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int dist[][] = new int[m][n];

        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int direction[][] = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        Deque<int[]> deq = new ArrayDeque<>();
        dist[0][0] = grid.get(0).get(0);

        deq.offerFirst(new int[]{0, 0});

        while(!deq.isEmpty()){
            int cur[] = deq.pollFirst();
            int r = cur[0];
            int c = cur[1];

            for(int dir[] : direction){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n){
                        continue;
                    }

                int newCost = dist[r][c] + grid.get(nr).get(nc);
                if(newCost < dist[nr][nc]){
                    dist[nr][nc] = newCost;
       

                    if(grid.get(nr).get(nc) == 0){
                        deq.offerFirst(new int[]{nr, nc});
                    } else{
                        deq.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }
        int x = dist[m-1][n-1];

        return ((health - x) >= 1);
    }
}
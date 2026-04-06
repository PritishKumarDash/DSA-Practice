class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] height = new int[n][m];

        Queue<int[]> que = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isWater[i][j] == 1){
                    height[i][j] = 0;
                    que.offer(new int[]{i, j});
                }else{
                    height[i][j] = -1;
                }
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!que.isEmpty()){
            int curr[] = que.poll();
            int i = curr[0];
            int j = curr[1];

            for(int[] dir : directions){
                int ni = dir[0] + i;
                int nj = dir[1] + j;

                if(ni < n && nj < m && ni >= 0 && nj >= 0 && height[ni][nj] == -1){
                    height[ni][nj] = height[i][j] + 1;
                    que.offer(new int[]{ni, nj});
                }
            }
        }
        return height;
    }
}
class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] > 0){
                    int curr = dfs(grid, i, j);
                    max = Math.max(max, curr);
                }
            }
        }
        return max;
    }
    int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >=  grid.length || j >=  grid[0].length || grid[i][j] == 0){
            return 0;
        }
        int fish = grid[i][j];
        grid[i][j] = 0;

        fish += dfs(grid, i+1, j);
        fish += dfs(grid, i-1, j);
        fish += dfs(grid, i, j+1);
        fish += dfs(grid, i, j-1);

        return fish;
    }
}
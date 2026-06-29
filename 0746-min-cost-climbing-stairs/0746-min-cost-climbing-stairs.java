class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        int cos = recur(cost, n, dp);
        return cos;
    }
    int recur(int[] cost, int n, int[] dp){
        if(n == 0 || n == 1){
            dp[n] = 0;
            return dp[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int first = cost[n-1] + recur(cost, n-1, dp);
        int second = cost[n-2] + recur(cost, n-2, dp);

        dp[n] = Math.min(first, second);
        return dp[n];
    }
}
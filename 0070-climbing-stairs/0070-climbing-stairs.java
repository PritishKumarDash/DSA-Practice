class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        // int dp[] = new int[n+1];

        // dp[1] = 1;
        // dp[2] = 2;

        // for(int state = 3; state <= n; state++){
        //     dp[state] = dp[state - 1] + dp[state - 2];
        // }
        // return dp[n];

        int prev1 = 1;
        int prev2 = 2;
        int ans = 0;

        for(int state = 3; state <= n; state++){
            ans = prev1 + prev2;
            prev1 = prev2;
            prev2 = ans;
        }
        return ans;
    }
}
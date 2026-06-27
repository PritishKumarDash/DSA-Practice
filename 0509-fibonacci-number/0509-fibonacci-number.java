class Solution {
    public int fib(int n) {
        // if(n==0) return 0;
        // if(n==1) return 1;

        // return fib(n-1) + fib(n-2);

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return recur(n, dp);
    }
    public int recur(int n, int dp[]){
        if(n <= 1){
            dp[n] = n;
            return dp[n];
        }

        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }
}
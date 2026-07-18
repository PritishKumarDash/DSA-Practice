class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
             dp[i][j] = -1; 
            }
        }
        return helper(m-1, n-1, new StringBuilder(s1), new StringBuilder(s2), dp);
    }
    static int helper(int i, int j, StringBuilder s1, StringBuilder s2, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + helper(i-1, j-1, s1, s2, dp);
        int pick = helper(i-1, j, s1, s2, dp);
        int nopick = helper(i, j - 1, s1, s2, dp);
        return dp[i][j] = Math.max(pick, nopick);
    }
}
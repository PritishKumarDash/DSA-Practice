class Solution {
    public int rob(int[] nums) {
        // int ans = 0;
        // int ans1 = 0;
        // for(int i = 0; i < nums.length; i++){
        //     if(i % 2 == 0){
        //         ans += nums[i];
        //     }else{
        //         ans1 += nums[i];
        //     }
        // }
        // return Math.max(ans, ans1);

        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return recur(nums, n, dp);
    }

    public int recur(int[] nums, int index, int[] dp){
        if(index == 1){
            dp[index] = nums[0];
            return nums[0];
        }   
        if(index == 0){
            dp[index] = 0;
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }

        int pick = nums[index - 1] + recur(nums, index - 2, dp);
        int nopick = 0 + recur(nums, index - 1, dp);
        dp[index] = Math.max(pick, nopick);
        return dp[index];
    }
}
class Solution {
    public int rob1(int[] nums){
        int n = nums.length;
        int prev2 = 0;
        int prev1 = nums[0];
        for(int state = 2; state <= n; state++){
            int first = nums[state-1] + prev2;
            int second = 0 + prev1;
            int ans = Math.max(first, second);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int num1[] = new int[n-1];
        int num2[] = new int[n-1];

        int j=0;
        int k=0;
        for(int i = 0; i < n; i++){
            if(i != 0){
                num1[j] = nums[i];
                j++;
            }
            if(i != n-1){
                num2[k] = nums[i];
                k++;
            }
        }

        return Math.max(rob1(num1), rob1(num2));
    }
}
class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int[] neww = new int[n];

        for(int i = 0; i < n; i++){
            int temp = nums[i];
            int sum = 0;
            while(temp > 0){
                int rem = temp % 10;
                sum += rem;
                temp /= 10;
            }
            neww[i] = sum;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if( neww[i] < min ){
                min = neww[i];
            }
        }
        return min;
    }
}
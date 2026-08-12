class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        int maxfreq = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(map.get(nums[i]) > k){
                map.put(nums[j], map.get(nums[j])-1);
                if(map.get(nums[j]) == 0){
                    map.remove(nums[j]);
                }
                j++;
            }
           maxfreq = Math.max(maxfreq, i - j + 1);
            
        }
        return maxfreq;
    }
}
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int st = nums[0];
        int end = nums[n-1];
        int k = 0;
        for(int i = st; i <= end; i++){
            while (k < n && nums[k] < i) {
                k++;
            }

            if (k >= n || nums[k] != i) {
                list.add(i);
            }

        }
        return list;
    }
}
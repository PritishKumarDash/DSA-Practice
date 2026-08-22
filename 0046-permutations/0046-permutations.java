class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        solve(0, nums, list, new ArrayList<>());
        return list;
    }
    void solve(int i, int[] nums, List<List<Integer>> list, List<Integer> cur){
        if(i == nums.length){
            list.add(new ArrayList<>(cur));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(cur.contains(nums[j])) continue;

            cur.add(nums[j]);
            solve(i+1, nums, list, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
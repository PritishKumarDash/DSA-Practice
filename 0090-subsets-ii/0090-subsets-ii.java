class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        solve(0, nums, list, new ArrayList<>());
        return list;
    }
    void solve(int i, int[] nums, List<List<Integer>> list, List<Integer> cur){
        if(i == nums.length){
            if(list.contains(new ArrayList<>(cur))){
                return;
            }
            list.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        solve(i + 1, nums, list, cur);

        cur.remove(cur.size() - 1);

        solve(i+1, nums, list, cur);
    }
}
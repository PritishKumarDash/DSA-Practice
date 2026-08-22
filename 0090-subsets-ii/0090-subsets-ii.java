// // class Solution {
// //     public List<List<Integer>> subsetsWithDup(int[] nums) {
// //         Arrays.sort(nums);
// //         List<List<Integer>> list = new ArrayList<>();
// //         solve(0, nums, list, new ArrayList<>());
// //         return list;
// //     }
// //     void solve(int i, int[] nums, List<List<Integer>> list, List<Integer> cur){
// //         if(i == nums.length){
// //             if(list.contains(new ArrayList<>(cur))){
// //                 return;
// //             }
// //             list.add(new ArrayList<>(cur));
// //             return;
// //         }
// //         cur.add(nums[i]);
// //         solve(i + 1, nums, list, cur);

// //         cur.remove(cur.size() - 1);

// //         solve(i+1, nums, list, cur);
// //     }
// // }

// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Arrays.sort(nums);
//         Set<List<Integer>> set = new HashSet<>();

//         solve(0, nums, set, new ArrayList<>());

//         return new ArrayList<>(set);
//     }

//     void solve(int i, int[] nums,
//                Set<List<Integer>> set,
//                List<Integer> cur) {

//         if (i == nums.length) {
//             set.add(new ArrayList<>(cur));
//             return;
//         }

//         cur.add(nums[i]);
//         solve(i + 1, nums, set, cur);

//         cur.remove(cur.size() - 1);

//         solve(i + 1, nums, set, cur);
//     }
// }

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        solve(0, nums, list, new ArrayList<>());

        return list;
    }

    void solve(int i, int[] nums,
               List<List<Integer>> list,
               List<Integer> cur) {

        if (i == nums.length) {
            list.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        solve(i + 1, nums, list, cur);

        cur.remove(cur.size() - 1);

        int next = i + 1;

        while (next < nums.length && nums[next] == nums[i]) {
            next++;
        }

        solve(next, nums, list, cur);
    }
}
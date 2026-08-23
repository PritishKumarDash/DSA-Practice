// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         Set<List<Integer>> set = new HashSet<>();
//         solve(0, candidates, set, new ArrayList<>(), target);
//         return new ArrayList<>(set);
//     }
//     void solve(int i, int[] arr, Set<List<Integer>> set, List<Integer> cur, int target){

//         if(target == 0) {
//             set.add(new ArrayList<>(cur));
//             return;
//         }

//         if(i == arr.length || target < 0) return;

//         cur.add(arr[i]);

//         solve(i+1, arr, set, cur, target - arr[i]);

//         solve(i, arr, set, cur, target - arr[i]);

//         cur.remove(cur.size() - 1);

//         solve(i+1, arr, set, cur, target);
//     }
// }

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    void solve(int i, int[] arr, int target,
               List<List<Integer>> ans,
               List<Integer> cur) {

        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        if (i == arr.length || target < 0) {
            return;
        }

        cur.add(arr[i]);

        solve(i, arr, target - arr[i], ans, cur);

        cur.remove(cur.size() - 1);

        solve(i + 1, arr, target, ans, cur);
    }
}
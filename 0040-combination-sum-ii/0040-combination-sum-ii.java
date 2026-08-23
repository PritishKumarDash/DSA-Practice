class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

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

        solve(i + 1, arr, target - arr[i], ans, cur);

        cur.remove(cur.size() - 1);

        int next = i + 1;

        while (next < arr.length && arr[next] == arr[i]) {
            next++;
        }

        solve(next, arr, target, ans, cur);
    }
}
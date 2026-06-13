class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(0, graph.length- 1, graph, path);

        return ans;
    }

    void dfs(int node, int dest, int[][] graph, List<Integer> path){
        if(node == dest){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int nei : graph[node]){
            path.add(nei);
            dfs(nei, dest, graph, path);
            path.remove(path.size() - 1);
        }
    }
}
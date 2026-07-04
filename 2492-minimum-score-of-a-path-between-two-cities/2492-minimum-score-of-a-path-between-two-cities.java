class Solution {
    int result = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int d = road[2];

            adj.get(u).add(new int[]{v, d});
            adj.get(v).add(new int[]{u, d});
        }
        boolean[] vis = new boolean[n+1];
        dfs(1, adj, vis);

        return result;
    }
    void dfs(int u, List<List<int[]>> adj, boolean[] vis){
        vis[u] = true;

        for(int edge[] : adj.get(u)){
            int v = edge[0];
            int dist = edge[1];

            result = Math.min(result, dist);

            if(!vis[v]){
                dfs(v, adj, vis);
            }
        }
    }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }         

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(source, destination, adj, vis);
    }

    private boolean dfs(int source, int dest, List<List<Integer>> adj, boolean[] vis){
        if(source == dest) return true;

        vis[source] = true;

        for(int nei : adj.get(source)){
            if(!vis[nei]){
                if(dfs(nei, dest, adj, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}
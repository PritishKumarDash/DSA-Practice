class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        boolean vis[] = new boolean[numCourses];
        boolean recPath[] = new boolean[numCourses];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            if(!vis[i]){
                if(dfs(i, adj, vis, recPath, st)){
                    return new int[0];
                }
            }
        }

        int ans[] = new int[numCourses];
        int idx = 0;
         while(!st.isEmpty()){
            ans[idx++] = st.pop(); 
         }
         return ans;
    }
     private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] recPath, Stack<Integer> stack){
        vis[node] = true;
        recPath[node] = true;

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                if(dfs(nei, adj, vis, recPath, stack)){
                    return true;
                }
            }
            else if(recPath[nei]){
                return true; 
            }
        }

        recPath[node] = false;

        stack.push(node); 
        return false;
    }
}

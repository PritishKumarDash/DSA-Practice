class Solution {
    public int findJudge(int n, int[][] trust) {
        int indeg[] = new int[n+1];
        int outdeg[] = new int[n+1];

        for(int edge[] : trust){
            int u = edge[0];
            int v = edge[1];

            outdeg[u]++;
            indeg[v]++;
        }

        for(int i = 1; i <= n; i++){
            if(indeg[i] == n-1 && outdeg[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
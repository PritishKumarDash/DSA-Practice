/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*/

/*
Approach: Topological Sort, DFS ,Cycle detection
TIme complexity: 0(V + E)
Space Complexity: 0(V + E)
*/

/*
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
*/
class Solution{
  public boolean canFinish(int numCourses, int[][] prerequisites){
    List<List<Integer>> adj = new ArrayList<>(); // it creates a list of empty list. adj = [ ]

    for(int i = 0; i < numCourses; i++){
      adj.add(new ArrayList<>()); // adj = [[], []]
    }

    for(int[] pre: prerequisites){
      adj.get(pre[1]).add(pre[0]); //pre[1] 0, pre[0] = 1. adj.get(0).add(1) -> adj = [[1],[]], 0 -> 1
    }

    boolean vis[] = new boolean[numCourses]; // vis[] = [F, F]
    boolean recPath[] = new boolean[numCourses]; // recPath = [F, F]

    for(int i = 0; i < numCourses; i++){
      if(!vis[i]){ // Checks if the i is visited or not
        if(dfs(i, adj, vis, recPath)){ // this function checks whether it contains a cycle or not. If cycle contains then the output is false.
          return false;                // dfs(0, adj, vis, recPath)
        }
      }
    }
    return true; // else true
  }

  private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] recPath){
    vis[node] = true; // vis[0] = T, vis[1] = true
    recPath[node] = true; // recPath[0] = t, recPath[1] = true

    for(int nei: adj.get(node)){ // adj.get(0) = 1, adj.get(1) = []
      if(!vis[nei]){ // vis[1] = F
        if (dfs(nei, adj, vis, recPath)){ // dfs(1, adj, vis, recPath)
          return true;
        }
      }else if(recPath[nei]){ 
        return true;
      }
    }
    recPath[node] = false; // recPath[1] = F, then it backtracks to dfs(0). recPath[0] = F
    return false; // no cycle detected
  }
}

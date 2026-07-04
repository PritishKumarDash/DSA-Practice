class Solution {
//     List<List<Integer>> adj = new ArrayList<>();
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         if(rooms.size() == 1){
//             return true;
//         }

//         for(int i = 0; i < rooms.size(); i++){
//             adj.add(new ArrayList<>());
//         }

//         for(int i = 0; i < rooms.size(); i++){
//             int u = rooms.get(i);

//             adj.get(i).add(u);
//         }

//         boolean vis[] = new boolean[rooms.size()];
//         vis[0] = true;

//         for(int i = 1; i < rooms.size(); i++){
//             if(dfs(adj.get(i), adj.get(i+1), vis)){
//                 return true;
//             }
//         }
//         return false;
//     }
//     boolean dfs(int source, int dest, boolean[] vis){
//         if(source == dest) return true;

//         vis[source] = true;

//         for(int nei : adj.get(source)){
//             if(!vi[nei]){
//                 if(dfs(nei, dest, vis)){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

    // DFS Approach     
    //     boolean[] vis = new boolean[rooms.size()];

    //     dfs(0, rooms, vis);

    //     for(int i = 0; i < rooms.size(); i++){
    //         if(!vis[i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // void dfs(int room, List<List<Integer>> rooms, boolean[] vis){
    //     vis[room] = true;

    //     for(int nei : rooms.get(room)){
    //         if(!vis[nei]){
    //             dfs(nei, rooms, vis);
    //         }
    //     }

    // BFS approach

    Queue<Integer> que = new LinkedList<>();
    boolean[] vis = new boolean[rooms.size()];

    que.offer(0);
    vis[0] = true;

    while(!que.isEmpty()){
        int node = que.poll();
        for(int nei : rooms.get(node)){
            if(!vis[nei]){
                vis[nei] = true;
                que.offer(nei);
            }
        }
    }
    for(boolean key : vis){
        if(!key){
            return false;
        }
    }
    return true;
    }
}

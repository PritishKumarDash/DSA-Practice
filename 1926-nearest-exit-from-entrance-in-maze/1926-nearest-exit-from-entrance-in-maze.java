class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        int dist = 0;

        while(!que.isEmpty()){
            int size = que.size();

            while(size-- > 0){
                int cur[] = que.poll();
                int r = cur[0];
                int c = cur[1];

                for(int dir[] : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nr >= maze.length || nc < 0 || nc >= maze[0].length) continue;

                    if(maze[nr][nc] == '+') continue;

                    if(nr == 0 || nr == maze.length - 1 || nc == 0 || nc == maze[0].length - 1) {
                        return dist + 1;
                    }
                    maze[nr][nc] = '+';
                    que.add(new int[] {nr, nc});

                }
            }
            dist++;
        }
        return -1;
    }
}
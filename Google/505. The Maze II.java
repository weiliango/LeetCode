class Solution {
    int[][] moves = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        maze[start[0]][start[1]] = -1;
        int ret = dfs(maze, start, destination, 0);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
    private int dfs(int[][] maze, int[] cur, int[] destination, int dist) {
        if(validate(cur, destination)) return dist;
        int ret = Integer.MAX_VALUE;
        for(int[] move: moves) {
            int[] cand = new int[]{cur[0] + move[0], cur[1] + move[1]};
            int len = 1;
            while(cand[0] >= 0 && cand[1] >= 0 && cand[0] < maze.length && cand[1] < maze[0].length && maze[cand[0]][cand[1]] != 1) {
                cand[0] += move[0];
                cand[1] += move[1];
                len++;
            }
            cand[0] -= move[0];
            cand[1] -= move[1];
            len--;
            if(maze[cand[0]][cand[1]] == 0) {
                maze[cand[0]][cand[1]] = -1;
                // System.out.println(dist + len);
                ret = Math.min(ret, dfs(maze, cand, destination, dist + len));
                maze[cand[0]][cand[1]] = 0;
            }
        }
        return ret;
    }
    private boolean validate(int[] cur, int[] destination) {
        return cur[0] == destination[0] && cur[1] == destination[1];
    }
}

class Solution {
    static final int[] DIRS = {0, 1, 0, -1, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(validate(start[0], start[1], destination))
            return 0;
        int[][] dist = new int[maze.length][maze[0].length];
        dist[start[0]][start[1]] = 1;
        dfs(maze, start[0], start[1], destination, dist);
        return dist[destination[0]][destination[1]] - 1;
    }
    private void dfs(int[][] maze, int cur_x, int cur_y, int[] destination, int[][] dist) {
        for(int i = 0; i < DIRS.length - 1; i++) {
            int x = cur_x + DIRS[i];
            int y = cur_y + DIRS[i+1];
            int len = dist[cur_x][cur_y];
            while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += DIRS[i];
                y += DIRS[i+1];
                len++;
            }
            x -= DIRS[i];
            y -= DIRS[i+1];
            if(dist[x][y] > 0 && len >= dist[x][y])
                continue;
            dist[x][y] = len;
            if(validate(x, y, destination)) return;
            dfs(maze, x, y, destination, dist);
        }
    }
    private boolean validate(int x, int y, int[] destination) {
        return x == destination[0] && y == destination[1];
    }
}
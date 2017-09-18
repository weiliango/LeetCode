class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        maze[start[0]][start[1]] = -1;
        int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] move: moves) {
                int x = cur[0] + move[0];
                int y = cur[1] + move[1];
                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != 1) {
                    x += move[0];
                    y += move[1];
                }
                x -= move[0];
                y -= move[1];
                if(validate(x, y, destination))
                    return true;
                else {
                    if(maze[x][y] != -1) {
                        q.offer(new int[]{x, y});
                        maze[x][y] = -1;
                    }
                }
            }
        }
        return false;
    }
    private boolean validate(int x, int y, int[] destination) {
        return x == destination[0] && y == destination[1];
    }
}
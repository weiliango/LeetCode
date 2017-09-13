class Solution {
    int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<int[]> res = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++) {
            helper(visited, matrix, i, 0, res, false);
            helper(visited, matrix, i, matrix[0].length, res, true);
        }
        for(int j = 0; j < matrix[0].length; j++) {
            helper(visited, matrix, 0, j, res, false);
            helper(visited, matrix, matrix.length, j, res, true);
        }
        return res;
    }
    private boolean helper(boolean[][] visited, int[][] matrix, int i, int j, List<int[]> res, boolean target) {
        //target false: Atlantic true: Pacific
        if(visited[i][j])
            return res.contains(new int[]{i, j});
        boolean ret = false;
        if((i == 0 && j == matrix[0].length) || (i == matrix.length && j == 0)) {
            ret = true;
        }
        else if(i == 0 || j == 0) {
            ret = !target;
        }
        else if(i == matrix.length || j == matrix[0].length) {
            ret = target;
        } else {
            for(int[] next: move) {
                next[0] += i;
                next[1] += j;
                if(next[0] >= 0 && next[1] >= 0 && next[0] < matrix.length && next[1] < matrix[0].length)
                    if(matrix[i][j] >= matrix[next[0]][next[1]])
                        ret |= helper(visited, matrix, next[0], next[1], res, target);
            }
        }
        visited[i][j] = true;
        if(ret)
            res.add(new int[]{i, j});
        return ret;
    }
}
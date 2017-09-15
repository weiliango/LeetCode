class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] count = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'E') {
                    // count[i][j]++;
                    for(int k = i - 1; k >= 0 && grid[k][j] != 'W'; k--) {
                        if(grid[k][j] != 'E')
                            count[k][j]++;
                    }
                    for(int k = i + 1; k < grid.length && grid[k][j] != 'W'; k++) {
                        if(grid[k][j] != 'E')
                            count[k][j]++;
                    }
                    for(int k = j - 1; k >= 0 && grid[i][k] != 'W'; k--) {
                        if(grid[i][k] != 'E')
                            count[i][k]++;
                    }
                    for(int k = j + 1; k < grid[0].length && grid[i][k] != 'W'; k++) {
                        if(grid[i][k] != 'E')
                            count[i][k]++;
                    }
                }
            }
        }
        int ret = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                ret = Math.max(ret, count[i][j]);
            }
        }
        return ret;
    }
}

// you can write a better solution tomorrow
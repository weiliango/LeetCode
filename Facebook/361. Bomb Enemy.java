class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int max = Integer.MIN_VALUE;
        int[][] row = new int[grid.length+1][grid[0].length+1];
        int[][] col = new int[grid.length+1][grid[0].length+1];
        for(int i = 1; i <= grid.length; i++) {
            for(int j = 1; j <= grid[0].length; j++) {
                if(grid[i-1][j-1] == 'W') {
                    
                } else if(grid[i-1][j-1] == 'E') {
                    
                } else {
                    
                }
            }
        }
        return max;
    }
}
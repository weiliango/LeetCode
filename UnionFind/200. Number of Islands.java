public class Solution {
    int[] root;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int count = 0;
        this.grid = grid;
        root = new int[grid.length * grid[0].length];
        
        for(int i = 0; i < root.length; root[i] = i, i++);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    if(i + 1 < grid.length && grid[i+1][j] == '1' && !isConnected(new int[]{i, j}, new int[]{i+1, j}))
                        count--;
                    if(j + 1 < grid[0].length && grid[i][j+1] == '1' && !isConnected(new int[]{i, j}, new int[]{i, j+1}))
                        count--;
                }
            }
        }
        return count;
    }
    public boolean isConnected(int[] p, int[] q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if(pRoot == qRoot) return true;
        else {
            if( pRoot < qRoot )
                root[qRoot] = pRoot;
            else
                root[pRoot] = qRoot;
            return false;
        }
    }
    public int findRoot(int[] p) {
        int idx = p[0] * grid[0].length + p[1];
        while(idx != root[idx])
            idx = root[idx];
        return idx;
    }
}
public class Solution {
    int[] roots;
    int[][] matrix;
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if(positions == null || positions.length < 1 || positions[0].length < 1) return null;
        List<Integer> res = new LinkedList<Integer>();
        int count = 0;
        roots = new int[m*n];
        matrix = new int[m][n];
        for(int i = 0; i < roots.length; roots[i] = i, i++);
        for(int[] position: positions) {
            matrix[position[0]][position[1]] = 1;
            count++;
            if(position[0] - 1 >= 0 && matrix[position[0]-1][position[1]] == 1 && !isConnected(new int[]{position[0]-1, position[1]}, position)) count--;
            if(position[0] + 1 < matrix.length && matrix[position[0]+1][position[1]] == 1 && !isConnected(new int[]{position[0]+1, position[1]}, position)) count--;
            if(position[1] - 1 >= 0 && matrix[position[0]][position[1]-1] == 1 && !isConnected(new int[]{position[0], position[1]-1}, position)) count--;
            if(position[1] + 1 < matrix[0].length && matrix[position[0]][position[1]+1] == 1 && !isConnected(new int[]{position[0], position[1]+1}, position)) count--;
            res.add(count);
        }
        return res;
    }
    
    public boolean isConnected(int[] p, int[] q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if(pRoot == qRoot) {
            return true;
        }
        else {
            roots[pRoot] = qRoot;
            return false;
        }
    }
    
    public int findRoot(int[] point) {
        int idx = point[0] * matrix[0].length + point[1];
        while(roots[idx] != idx) {
            roots[idx] = roots[roots[idx]]; //path compression
            idx = roots[idx];
        }
        return idx;
    }
}
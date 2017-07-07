public class Solution {
    int[] roots;
    
    public int findCircleNum(int[][] M) {
        if(M == null || M.length < 1 || M[0].length < 1) return 0;
        roots = new int[M.length];
        int count = 0;
        for(int i = 0; i < M.length; roots[i] = i, i++);
        for(int i = 0; i < M.length; i++) {
            for(int j = i + 1; j < M[0].length; j++) {
                if(M[i][j] == 1) {
                    int root1 = findRoot(i);
                    int root2 = findRoot(j);
                    if( root1 != root2 ) {
                        roots[root2] = root1;
                    }
                }
            }
        }
        for(int i = 0; i < roots.length; i++) {
            if(roots[i] == i) count++;
        }
        return count;
    }
    public int findRoot(int n) {
        while(roots[n] != n) {
            n = roots[n];
        }
        return n;
    }
}
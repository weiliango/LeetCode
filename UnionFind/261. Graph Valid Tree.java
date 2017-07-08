public class Solution {
    int[] roots;
    
    public boolean validTree(int n, int[][] edges) {
        roots = new int[n];
        for(int i = 0; i < n; roots[i] = i, i++);
        for(int[] edge: edges) {
            int root1 = findRoot(edge[0]);
            int root2 = findRoot(edge[1]);
            if(root1 != root2) {
                if(root1 < root2)
                    roots[root2] = root1;
                else
                    roots[root1] = root2;
                n--;
            }
            if(root1 == root2) return false;
        }
        return n == 1;
    }
    public int findRoot(int n) {
        for(; roots[n] != n; n = roots[n]);
        return n;
    }
}
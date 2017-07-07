public class Solution {
    Queue<int[]> q;
    HashSet<Integer> set;
    
    public int countComponents(int n, int[][] edges) {
        ArrayList<int[]> list = new ArrayList<int[]>(Arrays.asList(edges));
        q = new LinkedList<int[]>();
        set = new HashSet<Integer>();
        int count = 0;
        
        while(list.size() != 0) {
            int[] edge = list.get(0);
            q.add(edge);
            list.remove(edge);
            while(!q.isEmpty()) {
                edge = q.poll();
                set.add(edge[0]);
                set.add(edge[1]);
                int idx = 0;
                while(idx < list.size()) {
                    int[] cur = list.get(idx);
                    if(edge[0] == cur[0] || edge[0] == cur[1] || edge[1] == cur[0] || edge[1] == cur[1]) {
                        q.add(cur);
                        list.remove(cur);
                    } else {
                        idx++;
                    }
                }
            }
            count++;
        }
        return count + n - set.size();
    }
}

// second solution, use union
public class Solution {
    int[] roots;
    public int countComponents(int n, int[][] edges) {
        roots = new int[n];
        for(int i = 0; i < n; roots[i] = i, i++); //init
        for(int[] edge: edges) {
            int root1 = findRoot(edge[0]);
            int root2 = findRoot(edge[1]);
            if(root1 != root2) {
                roots[root1] = root2;
                n--;
            }
        }
        return n;
    }
    public int findRoot(int n) {
        while(roots[n] != n) {
            n = roots[n];
        }
        return n;
    }
}
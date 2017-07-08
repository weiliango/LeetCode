public class Solution {
    int[] roots;
    int[] counts;
    HashMap<Integer, Integer> map;

    public int longestConsecutive(int[] nums) {
        map = new HashMap<Integer, Integer>();
        roots = new int[nums.length];
        counts = new int[nums.length];
        for(int i = 0; i < roots.length; i++) {
            roots[i] = i;
            counts[i] = 1;
            map.put(nums[i], i);
        }
        
        for(int num: nums) {
            if(map.containsKey(num-1))
                union(num, num-1);
            if(map.containsKey(num+1))
                union(num, num+1);
        }
        
        int max = 0;
        for(int count: counts)
            max = Math.max(max, count);
        return max;
    }
    public void union(int p, int q) {
        int pRoot = findRoot(map.get(p));
        int qRoot = findRoot(map.get(q));
        if(pRoot != qRoot) {
            counts[pRoot] += counts[qRoot];
            roots[qRoot] = pRoot;
        }
    }
    
    public int findRoot(int idx) {
        if(roots[idx] != idx) {
            roots[idx] = findRoot(roots[idx]);
        }
        return roots[idx];
    }
}


public class Solution {
    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return res;
    }
}
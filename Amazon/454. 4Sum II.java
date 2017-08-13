public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int c: C) {
            for(int d: D) {
                if(!map.containsKey(c+d))
                    map.put(c+d, 0);
                map.put(c+d, map.get(c+d) + 1);
            }
        }
        for(int a: A) {
            for(int b: B) {
                int target = -a-b;
                if(map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }
        return count;
    }
}
public class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for ( int i = 0; i < nums.length ; i++ ) {
        	if ( map.containsKey(nums[i]) ) {
        		map.put(nums[i], map.get(nums[i]) + 1);
        	} else {
        		map.put(nums[i], 1);
        	}
        }
        int max = 0;

        Map.Entry entry = map.pollFirstEntry(); 
        for (Map.Entry e : map.entrySet()) {
        	if ( Math.abs((Integer)e.getKey() - (Integer)entry.getKey()) == 1 
        		&& (Integer)entry.getValue() + (Integer)e.getValue() > max) {
        		max = (Integer)entry.getValue() + (Integer)e.getValue();
        	}
        	entry = e;
		}
		return max;
    }
}
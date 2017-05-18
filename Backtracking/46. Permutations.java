public class Solution {
    public List<List<Integer>> permute(int[] nums) {
  		List<List<Integer>> res = new LinkedList<List<Integer>>();
  		backtrack(nums, res, new LinkedList<Integer>(), 0);
  		return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer>list, int level) {
    	if ( level == nums.length ) {
    		res.add(new LinkedList<Integer>(list));	
    	}
    	for ( int i = 0; i < nums.length ; i++ ) {
    		if ( !list.contains(nums[i]) ) {
    			list.add(nums[i]);
    			backtrack(nums, res, list, level+1);
    			list.remove(list.size()-1);
    		}
    	}
    }
}
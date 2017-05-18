public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> nums_list = new LinkedList<Integer>();
        for ( int num : nums ) {
        	nums_list.add(num);
        }

        backtrack(res, nums_list, new LinkedList<Integer>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> nums, List<Integer> list) {
    	if ( nums.isEmpty() ) {
    		if ( !res.contains(list) ) {
	    		res.add(new LinkedList<Integer>(list));
    		}
    		return;
    	}
    	HashSet<Integer> set = new HashSet<Integer>();
    	int length = nums.size();
    	for ( int i = 0; i < length; i++ ) {
    		int curr = nums.get(i);
    		if ( set.contains(curr) ) {
    			continue;
    		} else {
    			set.add(curr);
    		}
    		list.add(curr);
    		nums.remove(i);

    		backtrack(res, nums, list);

    		nums.add(i, curr);
    		list.remove(list.size()-1);

    	}

    }
}
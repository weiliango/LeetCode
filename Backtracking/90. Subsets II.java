public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        dfs(res, nums, 0, new LinkedList<Integer>());
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] nums, int level, List<Integer> list) {
        if ( !res.contains(list)) {
            res.add(new LinkedList<Integer>(list));
        }
        for ( int i = level; i < nums.length; i++ ) {
            list.add(nums[i]);
            dfs(res, nums, i + 1, list);
            list.remove(list.size()-1);
        }
    }
}
class Solution {
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        backtrack(nums, target, new LinkedList<Integer>(), res);
        return res.size();
    }
    private void backtrack(int[] nums, int target, int sum, List<Integer> list, List<List<Integer>> res) {
        if(sum == target) {
            if(!res.contains(list)) {
                res.add(new LinkedList<Integer>(list));
            }
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(sum + nums[i] <= target) {
                    list.add(nums[i]);
                    backtrack(nums, target, sum + nums[i], list, res);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
//TLE

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= target)
                dp[nums[i]] = 1;
        }
        for(int i = 0; i <= target; i++) {
            for(int num: nums) {
                if(i - num >= 0)
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
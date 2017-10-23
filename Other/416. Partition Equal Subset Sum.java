class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int num: nums)
            target += num;
        if(target % 2 != 0)
            return false;
        else
            target /= 2;
        return dfs(nums, 0, new boolean[nums.length], 0, target);
    }
    public boolean dfs(int[] nums, int cur_sum, boolean[] visited, int start, int target) {
        for(int i = start; i < nums.length; i++) {
            if(!visited[i]) {
                int sum = nums[i] + cur_sum;
                if(sum == target) {
                    return true;
                }
                if(sum < target) {
                    visited[i] = true;
                    if(dfs(nums, sum, visited, start+1, target))
                        return true;
                    visited[i] = false;
                }
            }
        }
        return false;
    }
}
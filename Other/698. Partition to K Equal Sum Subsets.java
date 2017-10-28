class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target = 0;
        for(int num: nums)
            target += num;
        if(target % k != 0)
            return false;
        target = target / k;
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, visited, target, 0, k, 0);
    }
    private boolean backtrack(int[] nums, boolean[] visited, int target, int cur_sum, int k, int start) {
        if(k == 1)
            return true;
        for(int i = start; i < visited.length; i++) {
            int sum = cur_sum + nums[i];
            if(visited[i] == false && sum <= target) {
                visited[i] = true;
                if(backtrack(nums, visited, target, sum == target ? 0 : sum, sum == target ? k - 1: k, sum == target ? 0 : start + 1))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
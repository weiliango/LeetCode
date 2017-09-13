class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                min = Math.min(i - idx + 1, min);
                sum -= nums[idx++];
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length < 2) return 0;
        int p = 0;
        int q = nums.length-1;
        int[] min_arr = new int[nums.length];
        int[] max_arr = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length-i-1]);
            max_arr[i] = max;
            min_arr[nums.length-i-1] = min;
        }
        while(p <= q) {
            if(p + 1 < nums.length && nums[p] <= min_arr[p+1])
                p++;
            else if(q - 1 >= 0 && nums[q] >= max_arr[q-1])
                q--;
            else
                break;
        }
        return q - p + 1;
    }
}
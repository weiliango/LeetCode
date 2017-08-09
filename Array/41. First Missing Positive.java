public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] - 1 != i) {
                int p = i;
                int q = nums[i] - 1;
                if(nums[p] == nums[q])
                    break;
                nums[p] = nums[p] ^ nums[q];
                nums[q] = nums[p] ^ nums[q];
                nums[p] = nums[p] ^ nums[q];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]-1 != i)
                return i + 1;
        }
        return nums.length + 1;
    }
}
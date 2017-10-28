class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3)
            return true;
        int count = 0;
        if(nums[0] > nums[1]) {
            nums[0] = nums[1];
            count++;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                if (nums[i+1] >= nums[i-1]) {
                    nums[i] = nums[i+1];
                } else {
                    nums[i+1] = nums[i];
                }
                count++;
            }
        }
        return count < 2;
    }
}
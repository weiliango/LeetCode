public class Solution {
    public void rotate(int[] nums, int k) {
        rotate(0, nums.length - 1);
        rotate(0, k-1);
        rotate(k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start++] ^= nums[end--];
        }
    }
}
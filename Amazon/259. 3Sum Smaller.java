public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            // if(i == 0 || nums[i] != nums[i-1]) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                //while(j < k && nums[j] == nums[j+1]) j++;
                //while(k > j && nums[k] == nums[k-1]) k--;
                if(nums[i] + nums[j] + nums[k] < target) {
                    count += k - j;
                    j++;
                } else
                    k--;
            }
            // }
        }
        return count;
    }
}
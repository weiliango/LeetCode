public class Solution {
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);
       int min = nums[0] + nums[1] + nums[2];
       for(int i = 0; i < nums.length; i++) {
           if(i == 0 || nums[i] != nums[i-1]) {
               int j = i + 1;
               int k = nums.length - 1;
               while(j < k) {
                    int ans = nums[i] + nums[j] + nums[k];
                    if(Math.abs(target - ans) < Math.abs(target - min))
                        min = ans;
                    if(target - ans > 0) j++;
                    if(target - ans < 0) k--;
                    if(target - ans == 0) break;
               }
           }
       }
       return min;
    }
}
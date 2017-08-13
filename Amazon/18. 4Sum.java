public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                for(int j = i + 1; j < nums.length; j++) {
                    if( j == i + 1 || nums[j] != nums[j-1]) {
                        int p = j + 1;
                        int q = nums.length - 1;
                        while(p < q) {
                            int ans = nums[i] + nums[j] + nums[p] + nums[q];
                            if(ans == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                                while(p < q && nums[p] == nums[p+1]) p++;
                                while(p < q && nums[q] == nums[q-1]) q--;
                                q--;
                                p++;
                            }
                            if(ans < target)
                                p++;
                            if(ans > target)
                                q--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
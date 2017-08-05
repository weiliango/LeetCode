public class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int[] res = new int[2];
        for(int i = 1; i <= nums.length; i++) {
            set.add(i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                res[0] = nums[i];
            }
        }
        res[1] = set.iterator().next();
        return res;
    }
}

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1] < 0)
                res[0] = Math.abs(nums[i]);
            nums[Math.abs(nums[i])-1] *= -1;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1] < 0)
                sum += Math.abs(nums[i]);
        }
        sum += res[0];
        res[1] = (1+nums.length)*nums.length/2 - sum;
        return res;
    }
}
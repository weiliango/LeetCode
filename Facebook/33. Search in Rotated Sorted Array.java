class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return (target == nums[0] ? 0 : -1);
        if(nums.length == 2) {
            if(target == nums[0]) return 0;
            if(target == nums[1]) return 1;
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int pivot = 0;
        while(left < right) {
            pivot = (left + right) / 2;
            if(nums[pivot] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        left = pivot;
        right = pivot + nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            System.out.println(mid);
            if(getValue(mid, nums) == target)
                return mid % nums.length;
            else if(getValue(mid, nums) > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
    private int getValue(int idx, int[] nums) {
        return nums[idx % nums.length];
    }
}


class Solution {
    public int search(int[] nums, int target) {
        int p = 0;
        int q = nums.length - 1;
        while(p <= q) {
            int mid = (p + q) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) {
                if(nums[q] < target)
                    q = mid - 1;
                else
                    p = mid + 1;
            }
            if(nums[mid] > target) {
                if(nums[p] > target)
                    p = mid + 1;
                else
                    q = mid - 1;
            }
            if(nums[mid] < nums[q]) q = mid;
        }
        return -1;
    }
}
public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int[] nums = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++)
            nums[i] = arr.get(i);
        List<Integer> res = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(res.size() < k) {
                res.add(nums[i]);
                continue;
            }
            if(Math.abs(res.get(0) - x) > Math.abs(nums[i] - x)) {
                res.add(nums[i]);
                res.remove(0);
            }
        }
        return res;
    }
}
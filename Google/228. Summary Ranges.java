class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int start = 0;
        int end = 0;
        while(end < nums.length) {
            if(nums[end] - nums[start] != end - start) {
                if(start == end - 1)
                    res.add("" + nums[start]);
                else
                    res.add(nums[start] + "->" + nums[end - 1]);
                start = end;
            }
            end++;
        }
        if(start == end - 1)
            res.add("" + nums[start]);
        else
            res.add(nums[start] + "->" + nums[end - 1]);
        return res;
    }
}
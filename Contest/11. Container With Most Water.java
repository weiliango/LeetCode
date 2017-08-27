class Solution {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max_area = Integer.MIN_VALUE;
        while(lo < hi) {
            max_area = Math.max(max_area, Math.min(height[hi], height[lo]) * (hi-lo));
            if(height[lo] < height[hi])
                lo++;
            else
                hi--;
        }
        return max_area;
    }
}
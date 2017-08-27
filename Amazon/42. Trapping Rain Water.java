class Solution {
    public int trap(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int vol = 0;
        int bar = 0;
        while(lo <= hi) {
            if(height[lo] < height[hi]) {
                if(height[lo] < bar)
                    vol += bar - height[lo];
                bar = Math.min(height[lo++], height[hi]);
            } else {
                if(height[hi] < bar)
                    vol += bar - height[hi];
                bar = Math.min(height[lo], height[hi--]);
            }
        }
        return vol;
    }
}
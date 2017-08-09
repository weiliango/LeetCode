public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int num: nums) {
                if((num & (1 << i)) != 0 ) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0)
                ans |= (1 << i);
        }
        return ans;
    }
}
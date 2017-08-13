public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p = 0;
        int q = numbers.length - 1;
        int[] res = new int[2];
        while (p <= q) {
            int sum = numbers[p] + numbers[q];
            if(sum == target) {
                res[0] = p + 1;
                res[1] = q + 1;
                break;
            }
            if(sum < target)
                p += 1;
            else
                q -= 1;
        }
        return res;
    }
}
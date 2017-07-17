public class Solution {
    public int reverse(int x) {
        int rev = 0;
        int mask = x >= 0 ? 1: -1;
        x *= mask;
        while(x > 0) {
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10) ) return 0;
            rev *= 10;
            rev += x % 10;
            x /= 10;
        }
        return rev * mask;
    }
}
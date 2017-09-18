import java.util.*;
public class Solution {
    public static void main(String[] args) {
        System.out.println(consecutiveSum(15));
    }
    public static int consecutiveSum(int N) {
        int ret = 1;
        while(N % 2 == 0)
            N /= 2;
        for(int i = 3; N != 1; i+= 2) {
            int count = 0;
            while(N % i == 0) {
                count++;
                N /= i;
            }
            System.out.println(count);
            ret *= (count + 1);
        }
        ret -= 1;
        return ret;
    }
}
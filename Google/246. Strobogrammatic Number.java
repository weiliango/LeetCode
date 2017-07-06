public class Solution {
    char[] A = {'1', '6', '8', '9', '0'};
    char[] B = {'1', '9', '8', '6', '0'};
    public boolean isStrobogrammatic(String num) {
        if(num.length() == 0 ) return true;
        if(num.length() == 1 ) return num.charAt(0) == '0' || num.charAt(0) == '1' || num.charAt(0) == '8';
        char a = num.charAt(0);
        char b = num.charAt(num.length() - 1);
        for(int i = 0; i < 5; i++) {
            if(A[i] == a && B[i] == b)
                return isStrobogrammatic(num.substring(1, num.length()-1));
        }
        return false;
    }
}
public class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while ( k > 0 ) {
            boolean flag = true;
            for ( int i = 0; i < sb.length() - 1; i++ ) {
                if ( sb.charAt(i) > sb.charAt(i+1) ) {
                    sb.deleteCharAt(i);
                    k--;
                    flag = false;       
                    break;
                }
            }
            if ( flag ) {
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
        }   

        while( !sb.toString().equals("") ) {
            if ( sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }
        
        if ( sb.toString().equals("") || sb.toString().equals("0")) {
            return "0";
        }

        return sb.toString();   
    }
}
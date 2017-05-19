public class Solution {
    public boolean canWin(String s) {
		return helper(new StringBuilder(s));        
    }
    public boolean helper(StringBuilder sb) {
    	boolean win;
    	for ( int i = 0; i < sb.length() - 1 ; i++ ) {
    		if ( sb.charAt(i) == '+' && sb.charAt(i+1) == '+' ) {
    			sb.replace(i, i+2, "--" );
    			win = !helper(sb);
    			sb.replace(i, i+2, "++" );
    			if ( win ) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
}
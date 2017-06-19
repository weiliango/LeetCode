public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
        	@Override
        	public int compare(String s1, String s2) {
        		return s2.length() - s1.length();
        	}
        });
        //Arrays.sort(strs, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        for ( int i = 0; i < strs.length; i++ ) {
        	boolean flag = true;
        	int max_len = 0;
        	for ( int j = 0; j < strs.length; j++ ) {
        		if ( i == j ) continue;
        		if ( !isSubsequence(strs[i], strs[j]) ) {
        			max_len = Math.max(max_len, strs[i].length());
        		} else {
        			flag = false;
        		}
        	}
        	if ( flag ) {
        		return max_len;
        	}
        }
        return -1;
    }
    private boolean isSubsequence( String s1, String s2 ) {
    	int idx = 0;
    	for ( int i = 0; i < s2.length() && idx < s1.length(); i++ ) {
    		if ( s1.charAt(idx) == s2.charAt(i) ) 
    			idx++;
    	}
    	return idx == s1.length();
    }
}
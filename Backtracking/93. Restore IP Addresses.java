public class Solution {
    public List<String> restoreIpAddresses(String s) {
 		List<String> res = new LinkedList<String>();       
 		backtrack(res, new StringBuilder(), 0, 0, s);
 		return res;
    }
    public void backtrack( List<String> res, StringBuilder sb, int level, int index, String s) {
   		if ( level != 0 && level != 4) {
   			sb.append(".");
   		}

    	if ( level == 4 ) {
    		if ( sb.length() == s.length() + 3 ) {
    			res.add(sb.toString());
    		} else {
    			return;
    		}
    	}


    	for ( int i = index; i < s.length() && i <= index + 2; i++ ) {
    		String sub = s.substring(index, i + 1);
    		if ( Integer.parseInt(sub) > 255 ) {
    			continue;
    		}
    		sb.append(sub);
    		backtrack(res, sb, level+1, i+1, s);
    		sb.delete(sb.length() + index - i - 1, sb.length());
    	}
    }
}
public class Solution {
    public List<Integer> grayCode(int n) {
    	List<Integer> res 	= new LinkedList<Integer>();
    	StringBuilder sb 	= new StringBuilder();
    	for ( int i = 0; i < n ; i++ ) {
    		sb.append("0"); 	
    	} 
    	backtrack(n, sb, res);
    	return res;
    }
    public boolean backtrack(int n, StringBuilder sb, List<Integer> res) {
        int num = 0;
        if ( !sb.toString().equals("") ) {
        	num = Integer.parseInt(sb.toString(), 2);
        }

    	if ( !res.contains(num) ) {
    		res.add(num);
    	} else {
    	    return false;
    	}
    	if ( res.size() == Math.pow(2, n)) {
    		return true;
    	} 

    	for ( int i = sb.length() - 1; i >= 0; i-- ) {
    		if ( sb.charAt(i) == '0' ) {
    			sb.replace(i, i+1, "1");
    		} else {
    			sb.replace(i, i+1, "0");
    		}
    // 		System.out.println(sb);
    		if ( backtrack(n, sb, res)) {
    			return true;		
    		}	
    		//res.remove(Integer.parseInt(sb.toString(), 2));
 	   		if ( sb.charAt(i) == '0' ) {
    			sb.replace(i, i+1, "1");
    		} else {
    			sb.replace(i, i+1, "0");
    		}
    	}
    	return false;
    } 
}
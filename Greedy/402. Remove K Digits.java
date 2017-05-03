public class Solution {
	public String removeKdigits(String num, int k) {
    
    	StringBuilder sb 	= new StringBuilder();
    	String copy			= new String(num);   

    	while( k > 0 ) {
	    	for ( int i = 0; i < copy.length() - 1; i++ ) {
	    		if ( copy.charAt(i) >= copy.charAt(i+1)) {
	    		    k--;
	       			continue;
	    		}
	    		sb.append(copy.charAt(i));
	    	}

	    	copy = sb.toString();
	    }

    	// sb.append(num.charAt(num.length() - 1));

/*
    	while( k > 0 ) {
    	    int kp = k;
    	    for ( int i = sb.length() - 1; i >= 0; i-- ) {
    	        if ( sb.charAt(i) != '0' ) {
            		sb.deleteCharAt(i);
            		k--;
                    break;
    	        }
    	    }
    	    if( kp == k ) {
    	        break;
    	    }
    	}*/

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
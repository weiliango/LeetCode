public class Solution {
    public String decodeString(String s) {
		Stack<Character> stack = new Stack<Character>();
    	StringBuilder sb = new StringBuilder();
    	StringBuilder res = new StringBuilder();

    	for ( int i = 0; i < s.length(); i++ ) {
    		char curr = s.charAt(i);
    		if ( curr != ']' ) {
    			stack.push(curr);
    		} else {
    			StringBuilder tmp = new StringBuilder();
    			StringBuilder num = new StringBuilder();
    			while ( stack.peek() != '[') {
	    			tmp.insert(0, stack.pop());
    			}
    			stack.pop();
    			while ( stack.peek() >= '0' && stack.peek() <= '9' ) {
    				num.insert(0, stack.pop());
    				if ( stack.isEmpty() ) {
    					break;
    				}
    			}
    			for ( int j = 0; j < Integer.valueOf(num.toString()); j++ ) {
    				for ( int k = 0; k < tmp.length(); k++ ) {
    					stack.push(tmp.charAt(k));
    				}
    			}
    		}
    	}
    	while( !stack.isEmpty() ) {
    		res.insert(0, stack.pop());
    	}
    	return res.toString();
    }
}
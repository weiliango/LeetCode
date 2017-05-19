public class Solution {
    public boolean isValidSerialization(String preorder) {
    	Stack <String> stack = new Stack <String>();
    	String [] strs = preorder.split(","); 
    	for ( int i = 0; i < strs.length; i++ ) {
    		while ( strs[i].equals("#") && !stack.isEmpty() && stack.peek().equals("#") ) {
    			stack.pop();
    			if ( stack.isEmpty() ) {
    				return false;
    			}
    			stack.pop();
    		}
    		stack.push(strs[i]);
    	}

        // while( !stack.isEmpty() ) {
        //     System.out.println(stack.pop());
        // }    	
    	if ( stack.pop().equals("#") ) {
    		if ( stack.isEmpty() ) {
	    		return true;
        	}
    	}
    	return false;
    }
}
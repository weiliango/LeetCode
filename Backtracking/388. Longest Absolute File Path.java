public class Solution {
	public int lengthLongestPath(String input) {
		int max_len = 0; 
		Stack <Integer> stack = new Stack<Integer>();
		stack.push(0);

		for ( String s : input.split("\n") ) {
			int lev = s.lastIndexOf("\t") + 1;
			while ( stack.size() > lev + 1 ) {
				stack.pop();
			}
			int len = stack.peek() + s.length() - lev + 1;
			stack.push(len);
			if ( s.contains(".") ) {
				max_len = Math.max(max_len, len - 1);
			}
		} 
		return max_len;
	}
}
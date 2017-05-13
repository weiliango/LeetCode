public class Solution {
    public String parseTernary(String expression) {
 		Stack <Character> stack = new Stack <Character> ();
 		for ( int i = 0; i < expression.length() ; i++ ) {
 			char curr = expression.charAt(i);
 			if ( curr != ':' ) {
 				curr.push(curr);
 			} else {
 				StringBuilder sb = new StringBuilder();
 				while ( (char tmp = curr.pop()) != '?' ) {
 					sb.insert(0, tmp);
 				}
 				char condition = sb.pop();
 				
 			}
 		}
    }
}
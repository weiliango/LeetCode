public class Solution {
    public int lengthOfLastWord(String s) {
 		StringBuilder sb = new StringBuilder(s);
 		int size = sb.length() - 1;
 		int length = 0;
 		while ( size >= 0 ) {
 			if ( sb.charAt(size) == ' ') {
 				sb.deleteCharAt(size);
 			} else {
 				break;
 			}
 			size--;
 		}
 		while ( size >= 0 ) {
 			if ( sb.charAt(size) != ' ') {
 				length++;
 			} else {
 				break;
 			}
 			size--;
 		}
 		return length;
    }
}
public class Solution {
	HashMap <Character, String> map;
	
	public Solution () {
		this.map = new HashMap <Character, String>();
		this.map.put('2', "abc");
		this.map.put('3', "def");
		this.map.put('4', "ghi");
		this.map.put('5', "jkl");
		this.map.put('6', "mno");
		this.map.put('7', "pqrs");
		this.map.put('8', "tuv");
		this.map.put('9', "wxyz");
	} 

    public List<String> letterCombinations(String digits) {
    	List<String> res = new LinkedList<String>();
    	backtrack(digits, new StringBuilder(), res);
    	return res;
    }

    public void backtrack(String digits, StringBuilder sb, List<String> res) {
    	int len = sb.length();

    	if ( len == digits.length() ) {
    		if ( !sb.toString().equals("") ) {
	    		res.add(sb.toString());
    		}
    		return;
    	}

    	char digit = digits.charAt(len);
    	char[] arr = this.map.get(digit).toCharArray();

    	for ( int i = 0; i < arr.length ; i++ ) {
    		sb.append(arr[i]);
    		backtrack(digits, sb, res);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
}
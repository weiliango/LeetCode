public class Solution {
	HashMap<Character, Character> map = new HashMap<Character, Character>();
	char[] nums = {'0', '1', '6', '8', '9'};
    char[] single = {'0', '1', '8'};

    public List<String> findStrobogrammatic(int n) {
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        
        List<String> res = new LinkedList<String>();
        backtrack(res, new StringBuilder(), 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder sb, int idx, int n) {
    	if ( sb.length() == n ) {
    		res.add(sb.toString());
            return;
    	}
        if ( sb.length() == n - 1 ) {
            for ( int i = 0; i < 3; i++ ) {
                sb.insert(idx, single[i]);
                backtrack(res, sb, idx + 1, n);
                sb.deleteCharAt(idx);
            }
            return;
        }
    	for ( int i = 0; i < 5 ; i++ ) {
            if (idx == 0 && nums[i] == '0' ) continue;
    		sb.insert(idx, nums[i]);
            sb.insert(idx+1, map.get(nums[i]));
            backtrack(res, sb, idx + 1, n);
            sb.deleteCharAt(idx+1);
            sb.deleteCharAt(idx);
    	}
    }
}


public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    public List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        List<String> list = helper(n-2, m);
        List<String> res = new ArrayList<String>();
        for (String i: list) {
            if (m != n) res.add("0" + i + "0");
            res.add("1" + i + "1");
            res.add("6" + i + "9");
            res.add("8" + i + "8");
            res.add("9" + i + "6");
        }
        return res;
    }
}
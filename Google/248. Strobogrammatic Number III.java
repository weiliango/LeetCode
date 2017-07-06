public class Solution {
    public int strobogrammaticInRange(String low, String high) {
    	int count = 0;
        for (int i = low.length(); i <= high.length(); i++) {
        	List<String> list = helper(i, i);
        	if ( i == low.length() || i == high.length() )
	        	for (String s: list) {
	        		if ( i == low.length() && s.compareTo(low) < 0 ) continue;
                    if ( i == high.length() && s.compareTo(high) > 0 ) continue;
	        		count++;
	        	}
	        else
	        	count += list.size();
        }
        return count;
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
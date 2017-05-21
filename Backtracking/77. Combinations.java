public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        backtrack(res, n, k, new LinkedList<Integer>(), 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, int n, int k, List<Integer> list, int last) {
    	if ( k == 0 ) {
     		if ( !res.contains(list) ) {
    			res.add(new LinkedList<Integer>(list));
    		}
    		return;
    	}

    	for ( int i = last + 1; i <= n ; i++ ) {
    		if ( !list.contains(i) ) ) {
    			list.add(i);
    			backtrack(res, n, k - 1, list, i);
    			list.remove(list.size()-1);
    		}
    	}
    }
}
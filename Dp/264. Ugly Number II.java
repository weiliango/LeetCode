public class Solution {
    public int nthUglyNumber(int n) {
    	if ( n < 6 ) {
    		return n;
    	}
    	HashSet<Integer> set = new HashSet<Integer>();
    	set.add(1);
    	set.add(2);
    	set.add(3);
    	set.add(4);
    	set.add(5);
    	int count = 5;
    	int next = 6;
    	int res = 0;
    	while ( count < n ) {
    		if (  (next % 2 == 0 && set.contains(next/2)) 
    			||(next % 3 == 0 && set.contains(next/3))
    			||(next % 5 == 0 && set.contains(next/5))){
    			set.add(next);
    			res = next;
    			count++;
    		}
    		next++;
    	}  
    	return res;
    }
}
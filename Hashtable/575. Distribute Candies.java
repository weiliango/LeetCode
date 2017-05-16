public class Solution {
	HashMap <Integer, Integer> map = new HashMap <Integer, Integer>();
    public int distributeCandies(int[] candies) {
        map.clear();
        for ( int candy : candies ) {
        	if ( map.containsKey(candy) ) {
        		map.put(candy, map.get(candy) + 1);
        	} else {
        		map.put(candy, 1);
        	}
        }

        int brother = 0;
        int sister = 0;

        for ( int v: map.values() ) {
        	if ( v > 1 ) {
        		brother += v - 1;
        		sister++;
        	} else {
        		sister++;
        	}
        }

        while ( sister - brother > 1 ) {
        	sister--;
        	brother++;
        }

        return sister;
    }
}
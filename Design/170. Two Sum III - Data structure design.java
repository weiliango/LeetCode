// public class TwoSum {

// 	HashSet<Integer> set = new HashSet<Integer>();
//     /** Initialize your data structure here. */
//     public TwoSum() {
//     	set.clear();
//     }
    
//     /** Add the number to an internal data structure.. */
//     public void add(int number) {
//         set.add(number);
//     }
    
//     /** Find if there exists any pair of numbers which sum is equal to the value. */
//     public boolean find(int value) {
//     	Iterator<Integer> iter = set.iterator();
//     	while ( iter.hasNext() ) {
//     		int v = iter.next();
//     		if ( set.contains(value -v) && value - v != v) {
//     			return true;
//     		}
//     	}
//     	return false;
//     }
// }

// /**
//  * Your TwoSum object will be instantiated and called as such:
//  * TwoSum obj = new TwoSum();
//  * obj.add(number);
//  * boolean param_2 = obj.find(value);
//  */
public class TwoSum {
	HashMap <Integer, Integer> map = new HashMap <Integer, Integer>();
    /** Initialize your data structure here. */
    public TwoSum() {
        map.clear();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if ( map.containsKey(number) ) {
        	map.put(number, map.get(number) + 1);
        } else {
        	map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for ( int key : map.keySet()) {
        	if ( map.containsKey(value - key) ) {
        		if ( value - key == key && map.get(key) == 1 ) {
        			continue;
        		} else {
        			return true;
        		}
        	}
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
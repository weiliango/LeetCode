// public class Solution {
//    	LinkedList <Integer> min = new LinkedList <Integer> ();
//    	LinkedList <Integer> max = new LinkedList <Integer> ();
//     public boolean find132pattern(int[] nums) {

//     	min.clear();
//     	max.clear();
    	
//     	int _min = Integer.MAX_VALUE;
//     	int _max = Integer.MIN_VALUE;

//     	for ( int i = 0; i < nums.length ; i++ ) {
//     		if ( min.size() == 0 ) {
//     			min.add(nums[i]);
//     			_min = Math.min(_min, nums[i]);
//     			_max = Math.max(_max, nums[i]);
//     			continue;
//     		}
//     		if ( nums[i] > _min && nums[i] < _max ) {
// 	    		for ( int j = 0; j < max.size() ; j++ ) {
// 					if ( min.get(j) < nums[i] && max.get(j) > nums[i]) {
// 						return true;
// 					}								    				
// 	    		}    			
//     		}

//     		if ( min.size() > max.size()) {
//     			if ( min.get(min.size()-1) >= nums[i] ) {
//     				min.remove(min.size()-1);
//     				min.add(nums[i]);
//     			} else {
//     				max.add(nums[i]);
//     			}
//     		} else {
//     			if ( max.get(max.size()-1) <= nums[i] ) {
//     				max.remove(max.size()-1);
//     				max.add(nums[i]);
//     			} else {
//     				min.add(nums[i]);
//     			}
//     		}
// 			_min = Math.min(_min, nums[i]);
// 			_max = Math.max(_max, nums[i]);
//     	}
//     	return false;
//     }
// }
public class Solution {
    public boolean find132pattern(int[] nums) {
    	if ( nums.length < 3 ) {
    		return false;
    	}
    	TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    	for ( int i = 1; i < nums.length ; i++ ) {
    		if ( map.containsKey(nums[i]) ) {
    			map.put(nums[i], map.get(nums[i]) + 1);
    		} else {
    			map.put(nums[i], 1);
    		}
    	}
    	int min = nums[0];
 		for ( int i = 1; i < nums.length ; i++ ) {
 			map.put(nums[i], map.get(nums[i]) - 1);
 			if ( map.get(nums[i]) == 0 ) {
 				map.remove(nums[i]);
 			}
 			if ( nums[i] > min ) {
 				Integer second = map.lowerKey(nums[i]);
 				if ( second != null && second > min && second < nums[i]) {
 					return true;
 				}
 			} 
 			min = Math.min(nums[i],min);
		}       
        return false;
    }
}
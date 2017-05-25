public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
		int[] arr = new int[triangle.size()+1];
		int min = Integer.MAX_VALUE;

		for ( List<Integer> list : triangle ) {
	        for ( int i = list.size(); i > 0 ; i-- ) {
	            if (i == list.size()) {
	                arr[i] = arr[i-1] + list.get(i-1);
	                continue;
	            }
	            if (i == 1) {
	            	arr[i] = arr[i] + list.get(i-1);
	            	continue;
	            }
        		arr[i] = Math.min(arr[i-1], arr[i]) + list.get(i-1);
	        }	
        }        
        for ( int i = 1; i < arr.length ; i++ ) {
        	min = Math.min(arr[i],min);
        }
        return min;
    }
}
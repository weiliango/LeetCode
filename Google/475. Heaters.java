public class Solution {
	public int findRadius(int[] houses, int[] heaters) {
		int max = Integer.MIN_VALUE;
		Arrays.sort(heaters);
		for ( int house: houses ) {
			int index = Arrays.binarySearch(heaters, house);
			if ( index < 0 ) {
				index = (index + 1) * (-1);
			}
			max = Math.max(max, Math.min(heaters[index]-house, house-heaters[index-1]));
		}
		return max;
	}
}
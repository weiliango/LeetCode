public class Solution {
	public int canCompleteCircuit( int [] gas, int [] cost ) {

		int tank 	= 0;
		int sumGas 	= 0;
		int sumCost	= 0;
		int index	= 0;

		for ( int i = 0; i < gas.length ; i++ ) {

			sumCost += cost[i];
			sumGas 	+= gas[i];

			tank += gas[i] - cost[i];	

			if ( tank < 0 ) {
				index	= i + 1;
				tank 	= 0;
			}
		}

		if ( sumGas < sumCost) {
			return -1;
		}

		return index;

	}
}

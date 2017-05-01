public class Solution {
	public int[][] reconstructQueue( int[][] people ) {
		int [][] nqueue = new int [people.length][2];
		int [] 	 count 	= new int [people.length];
		int []   index  = new int [people.length];

		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare ( int[] a, int[] b ) {
				if ( a[0] == b[0] ) {
					return b[1] - a[1];
				}
				return a[0] - b[0];
			}
		});

		for (int i = 0; i < count.length; i++ ) {
			count[i] = i;
			index[i] = i;
		}


		for ( int i = 0; i < people.length ; i++ ) {
			nqueue[index[people[i][1]]][0] = people[i][0]; 
			nqueue[index[people[i][1]]][1] = people[i][1]; 
			
			for ( int j = index[people[i][1]] + 1; j < people.length ; j++ ) {
				if ( count[j] != -1 ) {
					count[j] -= 1;
				}
			}

			count[index[people[i][1]]] = -1;
			for ( int j = 0; j < count.length; j++ ) {
				if ( count[j] != -1 ) {
					index[count[j]] = j;
				}
			}
		}

		return nqueue;
	}
}
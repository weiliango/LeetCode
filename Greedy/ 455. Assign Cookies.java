public class Solution {
	public int findContentChildren(int [] g, int[] s) {
		if( g.length == 0 || s.length == 0 ) return 0;
		Arrays.sort(g);
		Arrays.sort(s);

		int p = 0;
		for ( int i = 0; i < s.length; i++ ) {
			if ( s[i] >= g[p] ) {
				p++;
				if ( p >= g.length) {
					return g.length;
				}
			}
		}
		return p;
	}
}
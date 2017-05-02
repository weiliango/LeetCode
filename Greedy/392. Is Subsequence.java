public class Solution {
	public boolean isSubsequence(String s, String t) {
		int ps	= 0;
		int pt	= 0;

        if (s.length() > t.length()) return false;
		if (s.length() < 1 || t.length() < 1) return true;
		if (s.length() == 1) {
			for ( int i = 0; i < t.length() ; i++ ) {
				if ( s.charAt(0) == t.charAt(i) ) {
					return true;
				}
			}
			return false;
		}

		while ( ps < s.length() && pt < t.length() ) {
			if ( s.charAt(ps) == t.charAt(pt) ) {
				ps++;
				pt++;
			} else {
				pt++;
			}
		}

		if ( ps == s.length() && s.charAt(ps-1) == t.charAt(pt-1) ) {
			return true;
		} else {
			return false;
		}
	}
}
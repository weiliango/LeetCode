public class Solution {
    public String reverseWords(String s) {
		char [] ch = s.toCharArray();
		System.out.println(ch);
		int p = 0;
		while ( p < ch.length) {
			if ( ch[p] != ' ') {
				int q = p;
				while( q < ch.length ) {
					if ( ch[q] == ' ') {
						break;
					}
					q++;
				}
				
				q--;
				
				int m = p;
				int n = q;
				while ( m < n ) {
					ch[m] ^= ch[n];
					ch[n] ^= ch[m];
					ch[m] ^= ch[n];
					m++;
					n--;
				}
				p = q;
			}
			p++;        	
		}       
		return String.valueOf(ch); 
    }
}
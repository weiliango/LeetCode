public class Solution {
    public String fractionAddition(String expression) {
 		List<Integer> numerator	 = new LinkedList<Integer>();
 		List<Integer> denominator= new LinkedList<Integer>();
 		
 		Stack<Character> stack = new Stack<Character>();
 		for ( int i = expression.length() - 1; i >= 0 ; i-- ) {
 			if ( expression.charAt(i) == '/' ) {
 				StringBuilder sb = new StringBuilder();
 				while ( !stack.isEmpty() ) {
 					sb.append(stack.pop());
 				}
 				denominator.add(Integer.parseInt(sb.toString()));
 				continue;
 			}
 			if ( expression.charAt(i) == '-' ) {
 				StringBuilder sb = new StringBuilder();
 				while ( !stack.isEmpty() ) {
 					sb.append(stack.pop());
 				}
 				numerator.add((-1)*Integer.parseInt(sb.toString()));
 			// 	numerator.get(numerator.size()-1) *= -1;
 				continue;
 			}
 			if ( expression.charAt(i) == '+') {
 				StringBuilder sb = new StringBuilder();
 				while ( !stack.isEmpty() ) {
 					sb.append(stack.pop());
 				}
 				numerator.add(Integer.parseInt(sb.toString()));
 				continue;
 			}
 			stack.push(expression.charAt(i));
		}

		if( !stack.isEmpty() ) {
			StringBuilder sb = new StringBuilder();
			while ( !stack.isEmpty() ) {
				sb.append(stack.pop());
			}
			numerator.add(Integer.parseInt(sb.toString()));
		}

		int currn = 0;
		int currd = 1;
        // System.out.println(numerator.get(0));
		for ( int i = 0; i < denominator.size() ; i++ ) {
			int mult = getMaxMult(currd, denominator.get(i));
			int tmp = currd * denominator.get(i) / mult;
			// System.out.println(currn);
			currn = currn * tmp / currd + numerator.get(i) * tmp / denominator.get(i);
			currd = tmp;
		}
		if ( currn == 0 ) {
			return "0/1";
		}
		int mult = Math.abs(getMaxMult(currn, currd));
		return (String.valueOf(currn/mult)+"/"+String.valueOf(currd/mult));
    }
    public int getMaxMult(int a, int b) {  
        int m = a % b;  
        while (m != 0) {  
            a = b;  
            b = m;  
            m = a % b;  
        }  
        return b;  
    }  
}
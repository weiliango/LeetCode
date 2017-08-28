class Solution {
    public int longestValidParentheses(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
               sum += 1;
            }
            if(ch == ')') {
                sum -= 1;
            }
            if(map.containsKey(sum)) {
                if(isValid(s.substring(map.get(sum) + 1, i + 1))) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
    private boolean isValid(String s) {
        int count = 0;
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == '(') count++;
            if(chs[i] == ')') count--;
            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}




class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int last = -1;
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == '(')
                stack.push(i);
            if(chs[i] == ')') {
                if(stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        max = Math.max(max, i - last);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
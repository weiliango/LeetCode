class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if(stack.isEmpty())
                    return false;
                char cur = stack.pop();
                if(cur == '(' && ch != ')') return false;
                if(cur == '[' && ch != ']') return false;
                if(cur == '{' && ch != '}') return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
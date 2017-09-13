class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        List<String> list = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        int size = q.size();
        while(!q.isEmpty() && size > 0) {
            String cur = q.poll();
            if(isValid(cur))
                list.add(cur);
            StringBuilder sb = new StringBuilder(cur);
            for(int i = 0; i < cur.length(); i++) {
                char ch = sb.charAt(i);
                if(ch == '(' || ch == ')') {
                    sb.deleteCharAt(i);
                    if(!visited.contains(sb.toString())) {
                        q.offer(sb.toString());
                        visited.add(sb.toString());
                    }
                    sb.insert(i, ch);
                }
            }
            if(--size == 0) {
                if(list.size() == 0)
                    size = q.size();
            }
        }
        return list;
    }
    private boolean isValid(String s) {
        int count = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(')
                count++;
            if(ch == ')')
                count--;
            if(count < 0)
                return false;
        }
        return count == 0;
    }
}
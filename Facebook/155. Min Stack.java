class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    boolean flag = true;
    
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        if(flag) {
            s1.push(x);
        } else {
            s2.push(x);
        }
    }
    
    public void pop() {
        if(flag) {
            s1.pop();
        } else {
            s2.pop();
        }
    }
    
    public int top() {
        if(flag) {
            return s1.peek();
        } else {
            return s2.peek();
        }
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        if(flag) {
            int cur = s1.pop();
            
        } else {
            
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
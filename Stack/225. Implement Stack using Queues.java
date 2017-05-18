public class MyStack {

    Queue <Integer> s1;
    Queue <Integer> s2;
    int curr;

    /** Initialize your data structure here. */
    public MyStack() {
        this.s1     = new LinkedList<Integer>();
        this.s2     = new LinkedList<Integer>();
        this.curr   = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        // 0 means the stack in duty of write
        if ( curr == 0 ) {
            s1.add(x);
        } else {
            s2.add(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if ( curr == 0 ) {
            if ( s2.size() == 1 ) return s2.poll();
            if ( s2.size() == 0 ) {
                while ( s1.size() > 1 ) {
                    s2.add(s1.poll());
                }
                curr = 1;
                return s1.poll();
            }
        } else {
            if ( s1.size() == 1 ) return s1.poll();
            if ( s1.size() == 0 ) {
                while ( s2.size() > 1 ) {
                    s1.add(s2.poll());
                }
                curr = 0;
                return s2.poll();
            }
        }
        return -1;
    }
    
    /** Get the top element. */
    public int top() {
        int tmp = 0;
        if ( curr == 0 ) {
            while(s1.size() > 1) {
                s2.add(s1.poll());
            }
            tmp = s1.poll();
            s2.add(tmp);
            curr = 1;
        } else {
            while(s2.size() > 1) {
                s1.add(s2.poll());
            }
            tmp = s2.poll();
            s1.add(tmp);
            curr = 0;
        }
        return tmp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return s1.size() + s2.size() > 0 ? false : true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
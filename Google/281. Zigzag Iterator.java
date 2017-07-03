public class ZigzagIterator {
    List<Integer> v;
    int idx;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        idx = 0;
        int len_min = Math.min(v1.size(), v2.size());
        int len_max = Math.max(v1.size(), v2.size());
        v = v1.size() >= v2.size() ? v1 : v2;
        
        for(int i = len_min - 1; i >= 0; i--) {
            if(v1.size() < v2.size())
                v.add(i, v1.get(i));
            else
                v.add(i+1, v2.get(i));
        }
    }

    public int next() {
        return v.get(idx++);
    }

    public boolean hasNext() {
        if(idx < v.size())
            return true;
        else
            return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class ZigzagIterator {
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove(0);
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
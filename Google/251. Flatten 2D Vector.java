public class Vector2D implements Iterator<Integer> {
    
    Iterator <List<Integer>> list;
    Iterator iter;
        
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d.iterator();
        if (list.hasNext())
            iter = list.next().iterator();
    }

    @Override
    public Integer next() {
        return (Integer)iter.next();
    }

    @Override
    public boolean hasNext() {
        if(iter != null) {
            if(iter.hasNext()) {
                return true;
            } else {
                while(list.hasNext()) {
                    iter = list.next().iterator();
                    if(iter.hasNext())
                        return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
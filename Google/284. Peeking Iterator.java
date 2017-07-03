// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer peek = null;
    Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peek == null)
            peek = (Integer)iter.next();
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        int result;
	    if(peek != null) {
            result = peek;
            peek = null;
        } else {
            result = (Integer)iter.next();
        }
        return result;
	}

	@Override
	public boolean hasNext() {
        if(iter == null) return false;
	    return iter.hasNext() || peek != null;
	}
}
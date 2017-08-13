public class TwoSum {

    /** Initialize your data structure here. */
    ArrayList<Integer> list;
    HashSet<Integer> set;
    public TwoSum() {
        list = new ArrayList<Integer>();
        set = new HashSet<Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        for(int i: list) {
            set.add(number + i);
        }
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return set.contains(value);
    }
}

public class TwoSum {
    private HashMap<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!map.containsKey(number))
            map.put(number, 0);
        map.put(number, map.get(number) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key: map.keySet()) {
            if(map.containsKey(value - key) && (value - key) != key)
                return true;
            if((value - key) == key && map.get(key) >= 2)
                return true;
        }
        return false;
    }
}
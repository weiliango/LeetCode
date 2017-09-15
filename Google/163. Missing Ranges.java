class Solution {
    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        TreeMap<Integer, Interval> map = new TreeMap<>();
        HashSet<Integer> visited = new HashSet<>();
        map.put(lower, new Interval(lower, upper));
        for(int num: nums) {
            if(num < lower || num > upper) continue;
            if(visited.contains(num)) continue;
            visited.add(num);
            int key = num;
            if(!map.containsKey(key))
                key = map.lowerKey(num);
            Interval cur = map.get(key);
            map.remove(key);
            if(num - 1 >= cur.start && num >= Integer.MIN_VALUE + 1)
                map.put(num - 1, new Interval(cur.start, num - 1));
            if(num + 1 <= cur.end && num <= Integer.MAX_VALUE - 1)
                map.put(num + 1, new Interval(num + 1, cur.end));
        }
        List<String> res = new ArrayList<>();
        for(Interval cur: map.values()) {
            if(cur.start == cur.end)
                res.add(cur.start + "");
            else
                res.add(cur.start + "->" + cur.end);
        }
        return res;
    }
}
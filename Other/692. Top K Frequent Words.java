class Solution {
    class MyClass {
        String word;
        int count;
        public MyClass(String word, int count) {this.word = word; this.count = 0;}
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, MyClass> map = new HashMap<>();
        PriorityQueue<MyClass> q = new PriorityQueue(new Comparator<MyClass>(){
            @Override
            public int compare(MyClass o1, MyClass o2) {
                if(o1.count != o2.count)
                    return o2.count - o1.count;
                else
                    return o1.word.compareTo(o2.word);
            }
        });
        
        for(String word: words) {
            if(map.containsKey(word)) {
                map.get(word).count++;
            } else {
                MyClass newObj = new MyClass(word, 1);
                map.put(word, newObj);
                q.add(newObj);
            }
        }
        
        List<String> rst = new LinkedList<>();
        while(k-- > 0)
            rst.add(q.poll().word);
        return rst;
    }
}
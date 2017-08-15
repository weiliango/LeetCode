public class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        for(int num: nums) {
            if(!map.containsKey(num)) {
                map.put(num, 0);
                keys.add(num);
            }
            map.put(num, map.get(num) + 1);
        }
        return check(map, keys, 0);
    }
    
    private boolean check(HashMap<Integer, Integer> map, List<Integer> keys, int start) {
        int key = 0;
        boolean flag = true;
        for(int i = start; i < keys.size(); i++) {
            if(map.get(keys[i]) != 0) {
                key = keys[i];
                start = i;
                flag = false;
                break;
            }
        }
        if(flag)
            return true;
        int i = 0;
        while(keys.contains(key+i) && map.get(key+i) != 0){
            map.put(key+i, map.get(key+i) - 1);
            i++;
        }
        i--;
        while(i >= 2) {
            if(check(map, keys, start))
                return true;
            else {
                map.put(key+i, map.get(key+i) + 1);
                i--;
            }
        }
        while(i >= 0) {
            map.put(key+i, map.get(key+i) + 1);
            i--;
        }
        return false;
    }
}

public class Solution {
    public boolean isPossible(int[] nums) {
        
    }
}
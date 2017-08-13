public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer[] ans = new Integer[3];
        List<List<Integer>> res = new ArrayList<>();
        for(int num: nums) {
            if(!map.containsKey(num))
                map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }
        int[] keys = map.keySet();
        // for(int c: map.keySet()) {
        for(int i = 0; i < keys.length; i++) {
            int c = keys[i];
            for(int j = i + 1; j < keys.length; j++ )
                int a = keys[j];
            // for(int a: map.keySet()) {
                int b = -c - a;
                if(a == c && map.get(a) < 2)
                    continue;
                if(a == b && map.get(a) < 2)
                    continue;
                if(b == c && map.get(b) < 2)
                    continue;
                if(a == b && b == c && map.get(a) < 3)
                    continue;
                if(map.containsKey(b) && map.get(b) != 0) {
                    ans[0] = c;
                    ans[1] = a;
                    ans[2] = b;
                    Arrays.sort(ans);
                    List<Integer> candidate = new ArrayList<>(Arrays.asList(ans));
                    if(!res.contains(candidate))
                        res.add(candidate);
                }
            }
        }
        return res;
    }
}


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k) {
                    int a = nums[i] * -1;
                    int b = nums[j];
                    int c = nums[k];
                    if(b + c == a) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(j < nums.length - 1 && nums[j] == nums[j+1]) j++;
                        while(k > 0 && nums[k] == nums[k-1]) k--;
                        //j++;
                        //k--;
                    }
                    if(b + c < a)
                        j++;
                    else
                        k--;
                }
            }
        }
        return res;
    }
}
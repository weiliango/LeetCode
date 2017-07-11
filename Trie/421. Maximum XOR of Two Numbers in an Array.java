class TriNode {
    TriNode[] children = new TriNode[2];
}
public class Solution {
    TriNode root;
    
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        root = new TriNode();
        for(int num: nums) {
            TriNode ws = root;
            for(int i = 31; i >= 0; i--) {
                int bit = (num & (1 << i)) != 0 ? 1 : 0;
                if(ws.children[bit] == null)
                    ws.children[bit] = new TriNode();
                ws = ws.children[bit];
            }
        }
        for(int num: nums) {
            TriNode ws = root;
            int pMax = 0;
            for(int i = 31; i >= 0; i--) {
                if((num & (1 << i)) != 0) {
                    //1 -> 0
                    if(ws.children[0] != null) {
                        ws = ws.children[0];
                        pMax |= (1<<i);
                        // pMax += Math.pow(2, i);
                    }
                    else {
                        ws = ws.children[1];
                    }
                } else {
                    //0 -> 1
                    if(ws.children[1] != null) {
                        ws = ws.children[1];
                        pMax |= (1<<i);
                        // pMax += Math.pow(2, i);
                    }
                    else {
                        ws = ws.children[0];
                    }
                }
            }
            max = Math.max(max, pMax);
        }
        return max;
    }
}

public class Solution {
    HashSet<Integer> set = new HashSet<Integer>();
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;

        for(int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            for(int num: nums) {
                set.add(num & mask);
            }
            int pMax = max | (1 << i);
            for(int prefix : set) {
                if(set.contains(pMax ^ prefix)) {
                    max = pMax;
                }
            }
            set.clear();
        }
        return max;
    }
}
public class Solution {
    public int rotate(int[] arr, int[] opts) {
        if(arr == null || arr.length = 0) return 0;
        int max = arr[0];
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        for(int opt: opts) {
            idx -= opt;
            if(idx < 0)
                idx += arr.length;
        }
        return idx;
    }
}
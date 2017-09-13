class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0] != a2[0])
                    return a2[0] - a1[0];
                else
                    return a2[1] - a1[1];
            }
        });
        int max = 0;
        for(int i = envelopes.length - 1; i >= 0; i--) {
            for(int j = i; j < envelopes.length; j++) {
                if(i == j)
                    dp[i] = 1;
                else {
                    if(compare(envelopes[i], envelopes[j])) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    private boolean compare(int[] a, int[] b) {
        if(a[0] > b[0] && a[1] > b[1]) return true;
        return false;
    }
}

//concise solution
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0] != a2[0])
                    return a2[0] - a1[0];
                else
                    return a2[1] - a1[1];
            }
        });
        int max = 0;
        for(int i = envelopes.length - 1; i >= 0; i--) {
            if(compare(envelopes[i], envelopes[i+1])) {
                dp[i] = Math.max(dp[i], dp[i+1] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    private boolean compare(int[] a, int[] b) {
        if(a[0] > b[0] && a[1] > b[1]) return true;
        return false;
    }
}
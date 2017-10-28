class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                if(!s1[0].equals(s2[0])) {
                    return s1[0].compareTo(s2[0]);
                } else {
                    return s1[1].compareTo(s2[1]);
                }
            }
        });
        List<String> rst = new ArrayList<>();
        rst.add("JFK");
        dfs(tickets, "JFK", new boolean[tickets.length], 0, rst, 0);
        return rst;
    }
    private boolean dfs(String[][] tickets, String from, boolean[] used, int k, List<String> rst, int start) {
        if(k == tickets.length) {
            return true;
        }
        for(int i = start; i < tickets.length; i++) {
            if(!used[i] && tickets[i][0].equals(from)) {
                used[i] = true;
                String to = tickets[i][1];
                rst.add(to);
                if(dfs(tickets, to, used, k+1, rst, start)) {
                    return true;
                }
                used[i] = false;
                rst.remove(to);
            }
        }
        return false;
    }
}
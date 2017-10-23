class Solution {
    private double dfs(Map<String, Map<String, Double>> map, String cur, String target, HashSet<String> visited) {
        if(map.get(cur) == null)
            return 0.0;
        if(map.get(cur).get(target) != null)
            return map.get(cur).get(target);
        for(String key: map.get(cur).keySet()) {
            if(!visited.contains(key)) {
                visited.add(key);
                double rst = dfs(map, key, target, visited);
                if(rst != 0)
                    return rst * map.get(cur).get(key);
                visited.remove(key);
            }
        }
        return 0.0;
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        for(int i = 0; i < equations.length; i++) {
            String numerator = equations[i][0];
            String denominator = equations[i][1];
            double value = values[i];
            if(!map.containsKey(numerator)) {
                map.put(numerator, new HashMap<String, Double>());
                map.get(numerator).put(numerator, 1.0);
            }
            if(!map.containsKey(denominator)) {
                map.put(denominator, new HashMap<String, Double>());
                map.get(denominator).put(denominator, 1.0);
            }
            map.get(numerator).put(denominator, value);
            map.get(denominator).put(numerator, 1 / value);
            // //numerator
            // for(String key: map.get(denominator).keySet()) {
            //     if(key == numerator)
            //         continue;
            //     map.get(numerator).put(key, value * map.get(denominator).get(key));
            //     map.get(key).put(numerator, 1 / (value * map.get(denominator).get(key)));
            // }
            // //denominator
            // for(String key: map.get(numerator).keySet()) {
            //     if(key == denominator)
            //         continue;
            //     map.get(denominator).put(key, map.get(numerator).get(key) / value);
            //     map.get(key).put(denominator, 1 / (map.get(numerator).get(key) / value));
            // }
        }
        
        double[] rst = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String numerator = queries[i][0];
            String denominator = queries[i][1];
            rst[i] = dfs(map, numerator, denominator, new HashSet<String>());
            if(rst[i] == 0)
                rst[i] = -1.0;
        }
        return rst;
    }
}
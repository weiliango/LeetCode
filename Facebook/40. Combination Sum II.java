class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target, new LinkedList<Integer>(), res);
        return res;
    }
    public void backtrack(int[] candidates, int start, int sum, int target, List<Integer> list, List<List<Integer>> res) {
        if(sum == target) {
            List<Integer> candidate = new LinkedList<Integer>(list);
            if(!res.contains(candidate))
                res.add(candidate);
        }
        for(int i = start; i < candidates.length; i++) {
            if(sum + candidates[i] <= target) {
                list.add(candidates[i]);
                backtrack(candidates, i + 1, sum + candidates[i], target, list, res);
                list.remove(list.size()-1);
            }
        }
    }
}
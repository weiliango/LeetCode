class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates, res, new LinkedList<Integer>(), target, 0, 0);
        return res;
    }
    public void backtrack(int[] candidates, List<List<Integer>> res, List<Integer> list, int target, int sum, int start) {
        if(sum == target) {
            List<Integer> candidate = new LinkedList<Integer>(list);
            Collections.sort(candidate);
            if(!res.contains(candidate))
                res.add(candidate);
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] + sum > target) break;
            list.add(candidates[i]);
            backtrack(candidates, res, list, target, sum + candidates[i], i);
            list.remove(list.size()-1);
        }
    }
}
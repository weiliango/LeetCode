class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> res = new LinkedList<>();
        backtrack(k, n, 0, candidates, 0, new LinkedList<Integer>(), res);
        return res;
    }
    private void backtrack(int nums, int target, int sum, int[] candidates, int start, List<Integer> list, List<List<Integer>> res) {
        if(list.size() > nums || sum > target) return;
        if(list.size() == nums && sum == target) {
            res.add(new LinkedList<Integer>(list));
        } else {
            for(int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrack(nums, target, sum + candidates[i], candidates, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
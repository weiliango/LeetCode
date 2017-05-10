public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<LinkedList<Integer>>();
		helper(root, sum, new LinkedList<Integer>(), res);
		return res;
	}
	public void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
		if ( root == null ) return;

		int current = sum - root.val;

		if ( current == 0 ) {
			res.add(path.add(root.val));
		}

		if ( current < 0 ) {
			return;
		}

		if ( current > 0) {
			helper(root.left, current, path.add(root.val), res);
			helper(root.right, current, path.add(root.val), res);
		}	
	}
}
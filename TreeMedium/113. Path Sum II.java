public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> res = new LinkedList<List<Integer>>();
	    
		helper(root, sum, new LinkedList<Integer>(), res);
		return res;
	}
	public void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
		if ( root == null ) return;

		int current = sum - root.val;
        path.add(root.val);
		if ( current == 0 && root.left==null && root.right==null) {
			res.add(path);
		}
		helper(root.left, current, new LinkedList<Integer>(path), res);
		helper(root.right, current, new LinkedList<Integer>(path), res);
	}
}
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		return root == null ? false : helper(root.left, root.right);
	}
	public boolean helper(TreeNode left, TreeNode right) {
		if ( left == null && right == null ) return true;
		if ( left == null || right == null ) return false; 
		if ( left.val == right.val ) {
			return helper(left.left, right.right) && helper(left.right, right.left);
		}
		return false;
	}
}
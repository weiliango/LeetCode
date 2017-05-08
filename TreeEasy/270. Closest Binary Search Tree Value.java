public class Solution {
	int closest;
	public int closestValue(TreeNode root, double target) {
		closest = root.val;
		return helper(root, target);
	}
	public int helper(TreeNode root, double target) {
		if ( root == null ) {
			return closest;
		}
		if ( Math.abs(root.val - target) < Math.abs(closest - target) ) {
			closest = root.val;
		}
		return helper( root.val > target ? root.left : root.right, target);
	}
}
public class Solution {
	public int closestValue(TreeNode root, double target) {
		int closest = Math.abs(root.val - target);
		int value 	= root.val;
		TreeNode current = root;
		while ( current != null ) {
			if ( closest > Math.abs(current.val - target)) {
				closest = Math.abs(current.val - target);
				value 	= current.val;
			}
		}

		return value;
	}
}
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
    	TreeNode root;
    	helper(root, nums, 0, nums.length - 1);
    	return root;
	}
	public TreeNode helper(TreeNode root, int[] nums, int p, int q) {
		if ( p > q ) return;
		root.val = nums[p+q/2];
		root.left = new TreeNode();
		root.right = new TreeNode();

		helper(root.left, nums, p, p+q/2);
		helper(root.right, nums, p+q/2 + 1, q);
	}
}
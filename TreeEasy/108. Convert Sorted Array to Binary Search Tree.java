public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
    	if ( nums.length == 0 ) return null;
    	TreeNode root = new TreeNode(0);
    	helper(root, 0, nums.length - 1, nums);
    	return root;
    }
    public void helper(TreeNode root, int p, int q, int [] nums) {
    	int m		= (p + q) / 2;
    	root.val 	= nums[m];
    	if (p <= m - 1) {
    		root.left = new TreeNode();
    		helper(root.left, p, m - 1, nums);
    	}
    	if (q >= m + 1) {
    		root.right = new TreeNode();
    		helper(root.right, m + 1, q, nums);
    	}
    }
}
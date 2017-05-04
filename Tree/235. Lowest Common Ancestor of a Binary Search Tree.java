public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
	}

	public String helper(TreeNode root, TreeNode p) {
		if ( root == null ) return null;
		if ( root == p ) return p.value;
		
		int left  = helper(root.left, p);
		int right = helper(root.right, p);

		


	} 
}
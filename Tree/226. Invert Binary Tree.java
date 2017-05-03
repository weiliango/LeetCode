public class Solution {
	TreeNode tmp = new TreeNode();
	public TreeNode invertTree(TreeNode root) {
		helper(root);
		return root;
	}
	public void helper(TreeNode root) {
		if ( root != null ) {
			swapTreeNode(root.left, root.right);
			helper(root.left);
			helper(root.right);
		}
	}
	public void swapTreeNode(TreeNode a, TreeNode b) {
		tmp	= a;
		a 	= b;
		b 	= tmp;
	}
}
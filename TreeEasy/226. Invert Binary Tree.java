/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public TreeNode invertTree(TreeNode root) {
		helper(root);
		return root;
	}
	public void helper(TreeNode root) {
		if ( root != null ) {
 			swapTreeNode(root);
 			// TreeNode tmp = root.left;
 			// root.left    = root.right;
 			// root.right   = tmp; 
 			
			helper(root.left);
			helper(root.right);
		}
	}
	public void swapTreeNode(TreeNode root) {
	        TreeNode tmp = root.left;
	        root.left    = root.right;
	        root.right   = tmp;

	}
}

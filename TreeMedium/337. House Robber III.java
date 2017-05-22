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
    public int rob(TreeNode root) {
		if ( root == null ) return 0;
		if ( root.left == null && root.right == null ) return root.val;
		return Math.max(rob(root.left)+rob(root.right), 
			(root.left != null ? rob(root.left.left) + rob(root.left.right) : 0) + 
			(root.right != null ? rob(root.right.left) + rob(root.right.right) : 0) +
			root.val);			
    }
}
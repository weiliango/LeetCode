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
    public boolean isBalanced(TreeNode root) {
    	boolean[] res 	= new boolean[1];
    	res[0] 			= true;

    	helper(root, res);
    	return res;
    }
    public int helper(TreeNode root, boolean[] res) {
    	if ( root == null) return 0;
    	left 	= isBalanced(root.left); 
    	right 	= isBalanced(root.right);
		
		res[0] = res[0] && (Math.abs(left - right) <= 1);
    	return Math.max(left, right) + 1;  
    	
    }
}
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
	public int findTilt ( TreeNode root ) {
		int [] res = new int[1];
		res[0] = 0;
		helper(root, res);
		return res[0];
	}
	public int helper ( TreeNode root, int [] res ) {
		if ( root == null ) return 0;
		int left  = helper(root.left, res);
		int right = helper(root.right, res);

		res[0] += Math.abs(left - right);
        System.out.println(res[0]);
        
		return left + right + root.val;

	}
}
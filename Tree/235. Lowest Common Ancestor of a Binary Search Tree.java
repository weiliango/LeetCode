public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return ((root.val - p.val) * (root.val - q.val) <= 0 ) ? root : 
			root.val > p.val ? lowestCommonAncestor(root.left, p, q)  :
							   lowestCommonAncestor(root.right, p, q) ;
	}
}
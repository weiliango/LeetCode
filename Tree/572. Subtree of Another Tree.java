public class Solution {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(s);
		while ( !q.isEmpty() ) {
			TreeNode current = q.poll();
			if ( helper(current, t) ) {
				return true;
			}
			if ( current.left != null ) {
				q.add(current.left);
			}
			if ( current.right != null ) {
				q.add(current.right);
			}
		}
		return false;
	}
	public boolean helper(TreeNode s, TreeNode t) {
		if ( t == null && s == null ) return true;
		if ( t == null || s == null) return false;
		return s.val == t.val ? helper(s.left, t.left) && helper(s.right, t.right) : false;
	}
}
public class Solution {
	public int pathSum(TreeNode root, int sum){

		if( root == null ) return 0;

		Queue <TreeNode> q = new LinkedList<TreeNode>();
		int res = 0;
		q.add(root);
		while ( !q.isEmpty() ) {
			TreeNode current = q.poll();
			res += helper(current, sum);
			if( current.left != null )
				q.add(current.left);
			if( current.right != null )
				q.add(current.right);
		}
		return res;
	}
	public int helper (TreeNode root, int current){
		if ( root == null ) return 0;
		if ( current - root.val == 0 )
			return helper(root.left, current - root.val) + helper(root.right, current - root.val) + 1;
		else
			return helper(root.left, current - root.val) + helper(root.right, current - root.val);
	}
}
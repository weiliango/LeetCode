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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<Integer> res = new LinkedList<Integer>();

		if ( root == null ) {
			return res;
		}

		q.add(root);
		int size = q.size();
		int round = 0;
		int max = Integer.MIN_VALUE;

		while ( !q.isEmpty() ) {
			TreeNode current = q.poll();
			max = Math.max(max, current.val);

			if ( current.left != null ) {
				q.add(current.left);
			}
			if ( current.right != null ) {
				q.add(current.right);
			}

			if ( --size == 0 ) {
				size = q.size();
				round++;
				res.add(max);
				max = Integer.MIN_VALUE;
			}
		}

		return res;
    }
}
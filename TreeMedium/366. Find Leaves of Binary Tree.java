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
    public List<List<Integer>> findLeaves(TreeNode root) {
    	List<Integer> list = new LinkedList<Integer>();
    	List<TreeNode> leaves = new LinkedList<TreeNode>();
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	list.add(0);
        while (!list.isEmpty()) {
        	list.clear();
        	helper(root, leaves, list);
        	if (!list.isEmpty()) {
        		res.add(new LinkedList<Integer>(list));
        	}
        }
        return res;
    }
    public void helper(TreeNode root, List<TreeNode> leaves, List<Integer> list) {
    	if ( root == null ) {
    		return ;
    	}
    	if ( leaves.contains(root) ) {
    		return ;
    	}
    	if ( (root.left == null || leaves.contains(root.left)) 
    		&& (root.right == null || leaves.contains(root.right))) {
    		list.add(root.val);
    		leaves.add(root);
    	}
    	helper(root.left, leaves, list);
    	helper(root.right, leaves, list);
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	Stack<Integer> stack = new Stack<Integer>(); 
    public BSTIterator(TreeNode root) {
    	stack.clear();
    	helper(root);
    }

    public void helper(TreeNode root) {
        if ( root == null ) return;
    	if ( root.right != null ){
    		helper(root.right);
    	}
    	stack.push(root.val);
    	if ( root.left != null ) {
    		helper(root.left);
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty() ? false : true;
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop();
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
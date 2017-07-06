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
	Stack <TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
    	if (root != null ) stack.push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while (!stack.isEmpty()) {
        	if (isLeaf(stack.peek())) return true;
        	else {
        		TreeNode node = stack.pop();
        		if ( node.right != null ) stack.push(node.right);
        		stack.push(node);
        		if ( node.left != null ) stack.push(node.left);
        		node.left = null;
        		node.right = null;
        	}
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop().val;
    }

    public boolean isLeaf(TreeNode root) {
    	return (root.left == null) && (root.right == null);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
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
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    public void pushAll(TreeNode node) {
        for(; node != null; stack.push(node), node = node.left);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
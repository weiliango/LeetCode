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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(left != null) return left;
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(right != null) return right;
        if(find(root, p) && find(root,q))
            return root;
        return null;
    }
    
    private boolean find(TreeNode root, TreeNode p) {
        if(root == null) return false;
        return root == p || find(root.left, p) || find(root.right, p);
    }
}
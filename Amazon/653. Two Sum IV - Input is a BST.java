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
    TreeNode baseRoot;
    public boolean findTarget(TreeNode root, int k) {
        baseRoot = root;
        return helper(root, k);
    }
    public boolean helper(TreeNode root, int k) {
        if(root == null)
            return false;
        if(k - root.val == root.val)
            return helper(root.left, k) || helper(root.right, k);
        return traverse(baseRoot, k - root.val) || helper(root.left, k) || helper(root.right, k);
    }
    public boolean traverse(TreeNode root, int target) {
        if(root == null)
            return false;
        return root.val == target || (root.val > target ? traverse(root.left, target) : traverse(root.right, target));
    }
}
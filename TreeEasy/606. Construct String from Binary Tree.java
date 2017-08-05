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
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }
    public void helper(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append(root.val);
        if(root.left == null && root.right == null)
            return;
        sb.append('(');
        helper(root.left, sb);
        sb.append(')');
        if(root.right != null) {
            sb.append('(');
            helper(root.right, sb);
            sb.append(')');
        }
    }
}
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
    int _max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root != null) _max = 1;
        helper(root);
        return _max;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = helper(root.left);
        int right = helper(root.right);
        int cur_max = Math.max((left != 0 && root.left.val - root.val == 1) ? left + 1: 1,
                               (right != 0 && root.right.val - root.val == 1) ? right + 1: 1);
        _max = Math.max(cur_max, _max);
        return cur_max;
    }
}

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
    int _max;
    public int longestConsecutive(TreeNode root) {
        if(root != null) _max = 1; else return 0;
        helper2(root, root.val, _max);
        return _max;
    }
    public void helper2(TreeNode root, int target, int cur_max ) {
        if ( root == null ) {
            return;
        }
        if ( root.val == target + 1 ) {
            cur_max += 1;
            _max = Math.max(cur_max, _max);
        } else {
            cur_max = 1;
        }
        helper2(root.left, root.val, cur_max);
        helper2(root.right, root.val, cur_max);
    }
}
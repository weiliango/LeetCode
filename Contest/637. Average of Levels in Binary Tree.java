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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = q.size();
        int count = 0;
        long sum = 0;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            count++;
            sum += curr.val;
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
            if(--size == 0) {
                size = q.size();
                res.add(1.0 * sum / count);
                count = 0;
                sum = 0;
            }
        }
        return res;
    }
}
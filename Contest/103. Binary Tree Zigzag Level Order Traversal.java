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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        boolean zigzag = true;
        int size = q.size();
        List<Integer> candidate = new LinkedList();
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(zigzag) {
                candidate.add(curr.val);
            } else {
                candidate.add(0, curr.val);
            }
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
            if(--size == 0) {
                size = q.size();
                zigzag ^= true;
                res.add(candidate);
                candidate = new LinkedList();
            }
        }
        return res;
    }
}
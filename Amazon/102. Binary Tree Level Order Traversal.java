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
    private Map<Integer, List<Integer>> map;
    public List<List<Integer>> levelOrder(TreeNode root) {
        map = new HashMap<>();
        traversal(root, 0);
        List<List<Integer>> res = new LinkedList<>();
        int i = 0;
        while(map.containsKey(i)) {
            res.add(map.get(i));
            i++;
        }
        return res;
    }
    public void traversal(TreeNode root, int level) {
        if(root == null) return;
        if(!map.containsKey(level))
            map.put(level, new LinkedList<Integer>());
        map.get(level).add(root.val);
        traversal(root.left, level + 1);
        traversal(root.right, level + 1);
    }
}
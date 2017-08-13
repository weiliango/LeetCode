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
    private int min = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        map.put(0, new LinkedList<Integer>(root.val));
        traversal(root, 0);
        while(map.containsKey(min)) {
            res.add(map.get(min));
            min++;
        }
        return res;
    }
    
    public void traversal(TreeNode root, int level) {
        if(root.left != null) {
            if(!map.containsKey(level - 1))
                map.put(level - 1, new LinkedList<Integer>(root.left.val));
            min = Math.min(min, level);
        }
        if(root.right != null) {
            if(!map.containsKey(level - 1))
                map.put(level - 1, new LinkedList<Integer>(root.right.val));
        }
        traversal(root.left, level - 1);
        traversal(root.right, level + 1);
    }
}
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<Integer> levels = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        levels.add(0);
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int level = levels.poll();
            TreeNode curr = nodes.poll();
            if(!map.containsKey(level))
                map.put(level, new ArrayList<Integer>());
            map.get(level).add(curr.val);
            if(curr.left != null) {
                levels.add(level-1);
                nodes.add(curr.left);
                min = Math.min(min, level-1);
            }
            if(curr.right != null) {
                levels.add(level+1);
                nodes.add(curr.right);
                max = Math.max(max, level+1);
            }
        }
        for(int i = min; i <= max; i++)
            res.add(map.get(i));
        return res;
    }
}
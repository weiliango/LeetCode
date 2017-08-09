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
    HashMap<String, TreeNode> map = new HashMap<String, TreeNode>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        traverse(first(root));
        for(TreeNode node : map.values()) {
            if(node != null)
                res.add(node);
        }
        return res;
    }
    
    private TreeNode first(TreeNode root) {
        // why ?
        if (root == null) return null;
        if (root.left != null && root.right != null) return root;
        if (root.left != null) return first(root.left);
        return first(root.right);
    }
    
    private void traverse(TreeNode root) {
        if(root == null)
            return;
        String path = serialize(root);
        if(map.containsKey(path)) {
            map.put(path, root);
        } else {
            map.put(path, null);
        }
        traverse(root.left);
        traverse(root.right);
    }
    
    private String serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + ',' + serialize(root.left) + ',' + serialize(root.right);
    }
}
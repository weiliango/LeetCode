/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    Stack<Character> stack = new Stack<Character>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        return root.val + ",(" + serialize(root.left) + ")(" + serialize(root.right) + ")";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        TreeNode root = new TreeNode(0);
        int idx = data.indexOf(',');
        if(idx == -1) {
            root.val = Integer.parseInt(data);
            return root;
        }
        root.val = Integer.parseInt(data.substring(0, idx));
        String leftStr = new String();
        String rightStr = new String();
        
        for(int i = idx+1; i < data.length(); i++) {
            if(data.charAt(i) == '(')
                stack.push('(');
            if(data.charAt(i) == ')')
                stack.pop();
            if(stack.isEmpty()) {
                leftStr = data.substring(idx+2, i);
                rightStr = data.substring(i+2, data.length()-1);
                break;
            }
        }
        root.left = deserialize(leftStr);
        root.right = deserialize(rightStr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// You need consider bst!!!! it would be much faster
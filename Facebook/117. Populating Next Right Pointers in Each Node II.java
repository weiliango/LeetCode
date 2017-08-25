/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode start = root;
        while(start != null) {
            TreeLinkNode curr = start;
            TreeLinkNode pre = null;
            TreeLinkNode head = null;
            while(curr != null) {
                if(curr.left != null) {
                    if(pre != null)
                        pre.next = curr.left;
                    pre = curr.left;
                    if(head == null)
                        head = curr.left;
                }
                if(curr.right != null) {
                    if(pre != null)
                        pre.next = curr.right;
                    pre = curr.right;
                    if(head == null)
                        head = curr.right;
                }
                curr = curr.next;
            }
            start = head;
        }
    }
}
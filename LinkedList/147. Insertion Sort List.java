/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        insertionSortR(head);
        return head;
    }
    public void insertionSortR(ListNode node) {
        if(node == null || node.next == null) return;
        insertionSortR(node.next);
        while(node.next != null && node.val > node.next.val) {
            node.val ^= node.next.val;
            node.next.val ^= node.val;
            node.val ^= node.next.val;
            node = node.next;
        }
    }
}
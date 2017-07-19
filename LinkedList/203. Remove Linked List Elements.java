/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy.next;
        while(q != null) {
            if(q.val == val) {
                q = q.next;
                p.next = q;
            } else {
                q = q.next;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
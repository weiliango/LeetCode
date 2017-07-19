/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;
        while(n-- > 0) q = q.next;
        while(q != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
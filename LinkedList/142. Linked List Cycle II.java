/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        ListNode q = head;
        int c1 = 0;
        int c2 = 0;
        int circle = -1;
        while(q.next != null && q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
            c1 += 1;
            c2 += 2;
            if(p == q) {
                circle = c2 - c1;
                break;
            }
        }
        if(circle == -1) return null;
        
        p = head;
        q = head;
        while(circle-- > 0) p = p.next;
        while(p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
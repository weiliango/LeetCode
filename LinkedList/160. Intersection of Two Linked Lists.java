/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        int len_a = 0;
        int len_b = 0;
        
        for(;p != null; len_a++, p = p.next);
        for(;q != null; len_b++, q = q.next);
        for(int i = 0; i < Math.abs(len_a-len_b); i++) {
            if(len_a-len_b > 0) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        while(headA != null && headB != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
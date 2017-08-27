/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode len = head;
        int length = 0;
        while(len != null) {
            len = len.next;
            length++;
        }
        k %= length;
        k = length - k;
        while(--k > 0)
            head = head.next;
        System.out.println(head.val);
        ListNode tail = pre.next;
        pre.next = head.next;
        head.next = null;
        head = pre;
        while(head.next != null)
            head = head.next;
        head.next = tail;
        return pre.next;
    }
}
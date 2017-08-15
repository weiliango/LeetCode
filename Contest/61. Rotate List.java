/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int length = 1;
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        rotate(head, head, 0, Integer.MAX_VALUE, 0);
        return head;
    }
    
    private void rotate(ListNode head, ListNode tail, int start, int end, int curr) {
        while(curr++ < start)
            head = head.next;
        
        if(tail != null && curr <= end) {
            length++;
            rotate(head, tail.next);
        }
        swap(head, tail);
        head = head.next;
    }
    private void swap(ListNode node1, ListNode node2) {
        node1.val ^= node2.val;
        node2.val ^= node1.val;
        node1.val ^= node2.val;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode[] nodes = new ListNode[n-m+1];
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            if(m <= count && count <= n) {
                nodes[count-m] = curr;
            }
            curr = curr.next;
        }
        int p = 0;
        int q = nodes.length - 1;
        while(p < q) {
            nodes[p].val = nodes[p].val ^ nodes[q].val;
            nodes[q].val = nodes[p].val ^ nodes[q].val;
            nodes[p].val = nodes[p].val ^ nodes[q].val;
            p++;
            q--;
        }
        return head;
    }
}
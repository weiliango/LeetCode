/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // misunderstand the meaning of question
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if(swap(dummy.next)) {
            ListNode temp = dummy.next;
            dummy.next = dummy.next.next;
            temp.next = dummy.next.next;
            dummy.next.next = temp;
        }
        return dummy.next;
    }
    public boolean swap(ListNode node) {
        if(node.next == null) return false;
        if(swap(node.next)) {
            ListNode temp = node.next;
            node.next = node.next.next;
            temp.next = node.next.next;
            node.next.next = temp;
        } else {
            return true;
        }
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        swap(dummy);
        return dummy.next;
    }
    public void swap(ListNode node) {
        if(node != null && node.next != null && node.next.next != null) {
            ListNode tmp = node.next;
            node.next = node.next.next;
            tmp.next = node.next.next;
            node.next.next = tmp;
            swap(node.next.next);
        }
    }
}
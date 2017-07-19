/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//memory Limit Exceed for this Solution, the space must be 1
public class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int carry;
        while(head != null) {
            stack.push(head);
        }
        ListNode curr = stack.pop();
        curr.val += 1;
        carry = curr.val / 10;
        curr.val %= 10;
        while(carry != 0 && !stack.isEmpty()) {
            curr = stack.pop();
            curr.val += 1;
            carry = curr.val / 10;
            curr.val %= 10;
        }
        if(carry != 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = dummy.next;
            dummy.next = newHead;
        }
        return dummy.next;
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
    public ListNode plusOne(ListNode head) {
        int carry = plus(head);
        if(carry != 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
    public int plus(ListNode node) {
        int carry = 0;
        if(node.next == null) {
            node.val += 1;
        } else {
            node.val += plus(node.next);
        }
        carry = node.val / 10;
        node.val = node.val % 10;
        return carry;
    }
}
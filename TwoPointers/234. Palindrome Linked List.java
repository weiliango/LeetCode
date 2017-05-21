/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
    	if ( head == null ) {
    		return true;
    	}
    	        	
		int length = 1;
		
		ListNode p = head;
        ListNode q;
        ListNode tmp;
        ListNode tail;

		while ( p.next != null ) {
			length++;
		    p = p.next;
        }

        p = head;

        for ( int i = 1; i <= length / 2 ; i++ ) {
        	p = p.next;
        }

        q = p;
        p = p.next;
        for ( int i = length / 2; i < length - 1; i++ ) {
        	tmp = p;
        	p = p.next;
        	tmp.next = q;
        	q = tmp;
        }

        tail = q;


        for ( int i = 0; i < length / 2 ; i++ ) {

        	if ( head.val != tail.val ) {
        		return false;
        	}

        	head = head.next;
        	tail = tail.next;
        }

        return true;
    }
}
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode p = dummy;
        RandomListNode q = head;
        while(q != null) {
            p.next = new RandomListNode(q.label);
            p.next.next = null;
            p = p.next;
            map.put(p.label, p);
            q = q.next;
        }
        p = dummy.next;
        q = head;
        while(q != null) {
            if(q.random != null && map.containsKey(q.random.label))
                p.random = map.get(q.random.label);
            else
                p.random = null;
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }
}
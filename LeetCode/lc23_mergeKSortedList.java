// LeetCode 23. Merge k Sorted Lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // dummy head
        ListNode head = new ListNode(-1);
        ListNode current = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>( new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) pq.offer(l);
        }
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            current.next = n;
            current = n;
            if (n.next != null) pq.offer(n.next);
        }
        return head.next;
    }
}
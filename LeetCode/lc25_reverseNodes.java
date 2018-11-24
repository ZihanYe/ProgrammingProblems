// LeetCode 25. Reverse Nodes in K-group
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k<=1) return head;
        ListNode end = head;
        int i = 1;
        while (i<k && end != null){
            end = end.next;
            i++;
        }
        if (end == null) return head;
        ListNode nextGroup = end.next;
        ListNode cur = head;
        ListNode prev = null;
        while (prev != end) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        // prev points to the end
        head.next = reverseKGroup(nextGroup, k);
        return end;
    }
}
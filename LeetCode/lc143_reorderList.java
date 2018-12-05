// LeetCode 143 Reorder List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow is the mid node
        ListNode prev = slow;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        // prev = last node
        ListNode pt = head;
        while (prev != slow && pt != slow) {
            // insert prev in between pt and pt.next
            ListNode temp = prev.next;
            ListNode nextPt = pt.next;
            pt.next = prev;
            prev.next = nextPt;
            pt = nextPt;
            prev = temp;
        }
        
        if (prev == slow) {
            prev.next = null;
        } else {
            prev.next = null;
        }
    }
}
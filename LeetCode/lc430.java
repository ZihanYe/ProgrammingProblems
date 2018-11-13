// LeetCode 430. Flatten a multilevel doubly linked list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
import javafx.util.Pair;
class Solution {
    public Node flatten(Node head) {
        Pair<Node, Node> res = helper(head);
        return res==null? null: res.getKey();
    }
    
    Pair<Node, Node> helper(Node head){
        if (head == null) return null;
        Node prev = null;
        Node current = head;
        while (current != null) {
            current.prev = prev;
            Node temp = current.next;
            if (current.child != null) {
                Pair<Node, Node> sublist = helper(current.child);
                current.child = null;
                current.next = sublist.getKey();
                sublist.getKey().prev = current;
                sublist.getValue().next = temp;
                prev = sublist.getValue();
            } else {
                current.next = temp;
                prev = current;
            }
            current = temp;
        }
        return new Pair<Node,Node>(head, prev);
    }
}
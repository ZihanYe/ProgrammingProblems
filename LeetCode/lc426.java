// LeetCode 426. BST to sorted doubly linked list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        //System.out.println(root.val);
        Node head = root;
        Node left = root.left;
        Node right = root.right;
        root.left = root;
        root.right = root;
        if (left != null) {
            Node lefthead = treeToDoublyList(left);
            head = lefthead;
            // insert root at the end of list
            append(lefthead, root);
        }
        if (right != null) {
            Node righthead = treeToDoublyList(right);
            append(head,righthead);
        }
        return head;
    }
    
    void append(Node a, Node b) {
        Node taila = a.left;
        Node tailb = b.left;
        b.left = taila;
        taila.right = b;
        a.left = tailb;
        tailb.right = a;
    }
}
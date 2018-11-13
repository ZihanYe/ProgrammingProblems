// leetcode 662. Max Width of Binary Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> lst = new LinkedList<>();
        lst.add(root);
        int res = maxWidth(lst);
        return res;
    }
    
    int maxWidth(LinkedList<TreeNode> lst) {
        // trim null at two ends
        while (lst.size() > 0 && lst.peekFirst() == null)
            lst.pollFirst();
        while (lst.size() > 0 && lst.peekLast() == null)
            lst.pollLast();
        
        if (lst.size() == 0) return 0;
        int max = lst.size();
        LinkedList<TreeNode> ns = new LinkedList<>();
        for (TreeNode n: lst) {
            if (n != null) {
                ns.add(n.left);
                ns.add(n.right);
            }
            else {
                ns.add(null);
                ns.add(null);
            }
        }
        max = Math.max(max, maxWidth(ns));
        return max;
    }
}
// leetcode 114. Flatten Binary Tree into Linked List

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
    public void flatten(TreeNode root) {
        TreeNode t = helper(root);
    }
    
    TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode leftend = helper(root.left);
        TreeNode rightend = helper(root.right);
        if (leftend != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            leftend.right = temp;
        }
        root.left = null;
        if (rightend != null) return rightend;
        if (leftend != null) return leftend;
        return root;
    } 
}
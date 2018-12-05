// LeetCode 124.Binary Tree Max Sum

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import javafx.util.Pair;
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int a = helper(root);
        return res;
    }
    
    int helper(TreeNode root) {
        // assume root != null
        int maxEnd = root.val;
        int max = root.val;
        int sum = root.val;
        if (root.left != null) {
            int p = helper(root.left);
            maxEnd = Math.max(p+root.val, maxEnd);
            sum += p;
        }
        if (root.right != null) {
            int p = helper(root.right);
            maxEnd = Math.max(p+root.val, maxEnd);
            sum += p;
        }
        max = Math.max(max, maxEnd);
        max = Math.max(max, sum);
        res = Math.max(res, max);
        return maxEnd;
    }
}
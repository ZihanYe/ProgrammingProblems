// LeetCode 236.LCA

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Pair<Boolean, TreeNode> pair = lca(root, p, q);
        return pair.getValue();
    }
    
    public Pair<Boolean, TreeNode> lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new Pair(false, null);
        
        Pair<Boolean, TreeNode> p1 = lca(root.left,p,q);
        if (p1.getValue() != null) 
            return p1;
        Pair<Boolean, TreeNode> p2 = lca(root.right,p,q);
        if (p2.getValue() != null) 
            return p2;
        boolean b1 = p1.getKey();
        boolean b2 = p2.getKey();
        if ((b1 && b2) || ((b1 || b2) && (root.val == p.val || root.val == q.val))) {
            return new Pair(true, root);
        }
        return new Pair(b1 || b2 || root.val == p.val || root.val == q.val, null);
    }
}
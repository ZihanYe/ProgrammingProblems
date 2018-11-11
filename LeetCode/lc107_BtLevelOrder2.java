// LeetCode 107. Binary level order traversal 2

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<>();
        if (root == null) return lst;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> level = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur == null) {
                lst.add(level);
                level = new ArrayList<>();
                if (!q.isEmpty()) q.offer(null);
            } else {
                level.add(cur.val);
                if (cur.left!= null) q.offer(cur.left);
                if (cur.right!= null) q.offer(cur.right);
            }
        }
        Collections.reverse(lst);
        return lst;
        
    }
}
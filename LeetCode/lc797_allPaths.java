// LeetCode 797. All Paths from Source to Target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        Queue<List<Integer>> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(0);
        q.offer(init);
        while (!q.isEmpty()) {
            List<Integer> lst = q.poll();
            if (lst.size() > graph.length) break;
            int cur = lst.get(lst.size() - 1);
            if (cur == target) {
                res.add(lst);
                continue;
            }
            int[] next = graph[cur];
            for (int i=0; i<next.length; i++) {
                List<Integer> newl = new ArrayList<>(lst);
                newl.add(next[i]);
                q.offer(newl);
            }
        }
        return res;
    }
}
// LeetCode 547. Friend Circles

class Solution {
    public int findCircleNum(int[][] M) {
        Set<Integer> added = new HashSet<Integer>();
        int circle = 0;
        for (int i=0; i<M.length; i++) {
            if (added.contains(i)) continue;
            dfs(M,added,i);
            circle ++;
            if (added.size() == M.length) break;
        }
        return circle;
    }
    
    public void dfs(int[][] M, Set<Integer> s, int i) {
        s.add(i);
        for (int j=0; j<M[i].length;j++){
            if (M[i][j] == 1 && !s.contains(j))
                dfs(M,s,j);
        }
    }
}
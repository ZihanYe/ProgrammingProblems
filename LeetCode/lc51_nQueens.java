// 51. N-Queens

class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        List<String> sofar = new ArrayList<>();
        Set<Integer> usedColumn = new HashSet<>();
        Set<Integer> usedDiag = new HashSet<>();
        Set<Integer> usedRightDiag = new HashSet<>();
        dfs(n, sofar,usedColumn, usedDiag, usedRightDiag);
        return res;
    }
    
    void dfs(int n, List<String> sofar, Set<Integer> columns, Set<Integer> diags, Set<Integer> rightDiags) {
        if (sofar.size() == n) {
            res.add(sofar);
            return;
        }
        
        int row = sofar.size();
        for (int i=0; i< n; i++) {
            if (!columns.contains(i) && !diags.contains(row-i) && !rightDiags.contains(row+i)) {
                columns.add(i);
                diags.add(row-i);
                rightDiags.add(row+i);
                List<String> news = new ArrayList<>(sofar);
                news.add(gen(n,i));
                dfs(n, news, columns, diags, rightDiags);
                columns.remove(i);
                diags.remove(row-i);
                rightDiags.remove(row+i);
            }
        }
    }
    
    String gen(int n, int q) {
        StringBuilder sb = new StringBuilder();
        for (int i =0; i<n; i++) {
            if (i != q) sb.append(".");
            else sb.append("Q");
        }
        return sb.toString();
    }
}
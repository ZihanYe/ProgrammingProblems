// LeetCode 120. Triangle

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;
        int r = triangle.size();
        int n = triangle.get(r-1).size();
        if (n==0) return 0;
        int[] sum = new int[n+1];
        List<Integer> currentrow;
        int j = r;
        while (j>0) {
            currentrow = triangle.get(j-1);
            for (int i=0; i<currentrow.size(); i++)
                sum[i] = Math.min(sum[i],sum[i+1]) + currentrow.get(i);
            j--;
        }
        return sum[0];
    }
}
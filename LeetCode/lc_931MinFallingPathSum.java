// Leetcode 931. minimum falling path sum

class Solution {
    public int minFallingPathSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] dp = new int[rows][cols];
        for (int j=0; j<cols; j++){
            dp[rows-1][j] = A[rows-1][j];
        }
        for (int i=rows-2; i>=0; i--) {
            for (int j=0; j<cols; j++) {
                int min = dp[i+1][j];
                if (j -1 >= 0)
                    min = Math.min(min, dp[i+1][j-1]);
                if (j +1 < cols) {
                    min = Math.min(min, dp[i+1][j+1]);
                }
                dp[i][j] = min + A[i][j];
            }
        }
        int minsum = Integer.MAX_VALUE;
        for (int i=0; i<rows; i++) {
            minsum = Math.min(dp[0][i] , minsum);
        }
        return minsum;
    }
}
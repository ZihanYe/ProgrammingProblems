// Leetcode 801. Min swaps to make sequence increasing

class Solution {
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        int[][] dp = new int[len][2];
        dp[len-1][0] = 0;
        dp[len-1][1] = 1;
        for (int i=len-2; i>=0; i--){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            if (A[i] < A[i+1] && B[i] < B[i+1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i+1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i+1][1]+1);
            }
            if (A[i] < B[i+1] && B[i] < A[i+1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i+1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i+1][0]+1);
            }
        }
        return Math.min(dp[0][0], dp[0][1]);
    }
}

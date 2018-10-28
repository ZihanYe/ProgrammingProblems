// Leetcode 823. Binary tree with factors

class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        long mod = (long) 1000000007;
        long[] numbt = new long[A.length];
        Arrays.fill(numbt, 0);
        Arrays.sort(A);
        long total = 0;
        for (int i=0; i<A.length; i++) {
            long num = 1;
            int l = 0; 
            int r = i -1;
            while (l <= r) {
                if (A[l] * A[r] == A[i]) {
                    if (A[l] != A[r]) {
                        num = (num + (numbt[l] * numbt[r] * 2) % mod) % mod;
                    } else
                        num = (num + (numbt[l] * numbt[r]) % mod) % mod;
                    l ++;
                } else if (A[l] * A[r] < A[i]) {
                    l ++;
                } else {
                    r --;
                }
            }
            numbt[i] = num;
            total= (total+ num ) % mod;
        }
        return (int)total;
    }
}
// Leetcode 779. Kth symbol in grammar
class Solution {
    public int kthGrammar(int N, int K) {
        return nrowkth(N, K);
    }
    
    private int nrowkth(int n, int k) {
        if (n==1 && k==1) {
            return 0;
        }
        int lastindex = (int) Math.floor((k-1)/4) * 2;
        if (k%4 == 1 || k%4 == 2) {
            lastindex = lastindex + 1;
        } else {
            lastindex = lastindex + 2;
        }
        int last = nrowkth(n-1, lastindex);
        if (last==0) {
            if (k%2 == 1) return 0;
            else return 1;
        } else {
            if (k%2 == 1) return 1;
            else return 0;
        }
    }
}
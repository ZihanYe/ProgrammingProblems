// LeetCode 91. Decode ways

class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[] ways = new int[n+1];
        ways[n] = 1;
        ways[n-1] = chs[n-1] == '0'? 0: 1;
        for (int i=n-2;i>=0;i--){
            if (chs[i] == '0')
                continue;
            ways[i] += ways[i+1];
            if (valid(chs[i],chs[i+1]))
                ways[i] += ways[i+2];
        }
        return ways[0];
    }
    
    boolean valid(char a, char b) {
        if (a == '2') return b <= '6';
        if (a < '2') return true;
        return false;
    }
}
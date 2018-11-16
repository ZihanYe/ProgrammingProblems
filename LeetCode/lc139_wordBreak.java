// LeetCode 139. Word Break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (wordDict.isEmpty()) return false;
        
        Set<String> words = new HashSet<>();
        // dp[i][j] = s[i..j) can be splitted by wordDict
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        int minlen = Integer.MAX_VALUE;
        for (String w : wordDict) {
            words.add(w);
            minlen = Math.min(minlen, w.length());
        }

        // compute dp
        for (int l=minlen; l<=s.length(); l++) {
            for (int i=0; i<=s.length()-l; i++) {
                if (words.contains(s.substring(i,i+l))) {
                    dp[i][i+l] = true;
                    continue;
                }
                for (int j=i+minlen; j<=i+l-minlen && !dp[i][i+l]; j++)
                    dp[i][i+l] = dp[i][j] && dp[j][i+l];
            }
        }
        return dp[0][s.length()];
    }
}
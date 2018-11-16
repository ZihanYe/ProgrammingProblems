// LeetCode 214. Shortest Palindrome
// equivalant to finding the longest prefix palindrome in s

// optimal solution using KMP
class Solution {
    public String shortestPalindrome(String s) {
        String news = s + "#" + new StringBuilder(s).reverse().toString();
        int[] lps = new int[news.length()];
        lps[0] = 0;
        int i = 1;
        int len = 0;
        while (i < news.length()){
            if (news.charAt(i) == news.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len>0)
                    len = lps[len-1];
                else {// len == 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
        // lps[news.length()-1] is the length of longest palindrom of s#reverse(s)
        int length = lps[news.length()-1];
        return new StringBuilder(s.substring(length,s.length())).reverse().toString() + s;
    }
}



/* my first solution
class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;
        char ch = s.charAt(0);
        int i = 0;
        for (i=s.length(); i>0; i--) {
            if (ch == s.charAt(i-1)) {
                String sub = s.substring(0,i);
                String re = new StringBuilder(sub).reverse().toString();
                if (sub.equals(re)) break;
            }
        }
        String add = new StringBuilder(s.substring(i,s.length())).reverse().toString();
        add += s;
        return add;
    }
}
*/
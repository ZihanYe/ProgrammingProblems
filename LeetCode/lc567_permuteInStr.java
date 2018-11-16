// LeetCode 567.Permutation in String

// First solution (less efficient but straight forward)
public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        if (n == 0) return true;
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String pat = new String(chars);
        for (int i=0; i<=s2.length()-n; i++) {
            char[] sub = s2.substring(i,i+n).toCharArray();
            Arrays.sort(sub);
            if (pat.equals(new String(sub)))
                return true;
        }
        return false;
}

// second solution (using sliding window)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        if (n == 0) return true;
        char[] pat = s1.toCharArray();
        int[] map = new int[26];
        for (char ch : pat)
            map[ch-'a'] ++;
        int i =0;
        int j =0;
        char[] txt = s2.toCharArray();
        while (j<txt.length) {
            map[txt[j] - 'a'] --;
            while (i<=j && map[txt[j]-'a'] < 0) {
                map[txt[i] -'a'] ++;
                i ++;
            }
            if (j-i+1 == n) return true;
            j++;
        }
        return false;
    }
}
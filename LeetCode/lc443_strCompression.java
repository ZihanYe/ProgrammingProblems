// Leetcode 443. String Compression

class Solution {
    public int compress(char[] chars) {
        // in place
        int currentwrite = 0;
        int i = 0;
        while (i< chars.length) {
            char ch = chars[i];
            int j = i+1;
            while (j < chars.length && chars[j] == chars[i]) j++;
            chars[currentwrite] = ch;
            currentwrite ++;
            if (j-i > 1) {
                chars[currentwrite] = ch;
                char[] number = Integer.toString(j-i).toCharArray();
                for (char c : number) {
                    chars[currentwrite] = c;
                    currentwrite ++;
                }
            }
            i = j;
        }
        return currentwrite;
    }
}
// LeetCode 340. Longest substring with at most K distinct character

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k ==0) return 0;
        Map<Character, Integer> count = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        // [i .. j)
        while (j < s.length()) {
            //System.out.println(i + "," + j);
            char ch = s.charAt(j);
            if (count.containsKey(ch) || count.size() < k) {
                count.put(ch, count.getOrDefault(ch, 0)+1);
                max = Math.max(max, j-i+1);
                j++;
            } else {
                // shrink
                while (i < j) {
                    int occur = count.get(s.charAt(i));
                    if (occur == 1) {
                        count.remove(s.charAt(i));
                        i++;
                        break;
                    }
                    else count.put(s.charAt(i), occur-1);
                    i++;
                }
            }
        }
        return max;
    }
}
// leetcode 387. First unique character in a string

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i=0; i< n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) map.put(ch, n);
            else map.put(ch, i);
        }
        int min = n;
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            min = Math.min(item.getValue(), min);
        }
        return min < n? min : -1;
    }
}